package com.wzxlq.controller;

import com.wzxlq.dto.HttpDto;
import com.wzxlq.dto.ResponseDto;
import com.wzxlq.entity.Events;
import com.wzxlq.entity.Threshold;
import com.wzxlq.service.EventsService;
import com.wzxlq.service.ThresholdService;
import lombok.extern.slf4j.Slf4j;
import okhttp3.internal.http.HttpDate;
import org.influxdb.InfluxDB;
import org.influxdb.dto.BoundParameterQuery;
import org.influxdb.dto.Query;
import org.influxdb.dto.QueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Package: com.wzxlq.controller
 * @ClassName: httpController
 * @Author: 王照轩
 * @CreateTime: 2021/3/16 21:48
 * @Description:
 */

@RestController
@Slf4j
public class httpController {
    @Autowired
    private InfluxDB influxDB;

    @Value("${spring.influx.database}")
    private String database;
    @Value("${server.address}")
    private String address;
    @Resource
    private EventsService eventsService;
    @Resource
    private ThresholdService thresholdService;

    @GetMapping("httpCount")
    public ResponseDto getHttpCount(String ip,String port) {
        List<Threshold> thresholdList = thresholdService.queryAllByIp(ip);
        int page = 1; // 起始页（从0开始）
        int pageSize = 10;  // 每页条目数
        String pageQuery = " LIMIT " + pageSize + " OFFSET " + (page - 1) * pageSize;
         List<HttpDto> httpDtoList = new ArrayList<>();
        for (Threshold threshold : thresholdList) {
            Query query = BoundParameterQuery.QueryBuilder
                .newQuery("SELECT * FROM http_server_requests WHERE uri = $uri and app = $app and port = $port"  + " ORDER BY time DESC"
                        + pageQuery)
                .bind("uri", threshold.getInterfaceName())
                .bind("app",threshold.getIp())
                .bind("port",port)
                .create();
        List<Double> result = startQuery(query,address,port,threshold.getInterfaceName());
        httpDtoList.add(new HttpDto(threshold.getInterfaceName(),threshold.getThreshold(),result));
        }
        ResponseDto responseDto = new ResponseDto();
        responseDto.setContent(httpDtoList);
        return responseDto;
    }

    public List<Double> startQuery(Query query,String ip,String port ,String interfaceName) {
        Threshold threshold = thresholdService.queryByName(ip, interfaceName);
        log.info(interfaceName+"的阈值:"+threshold.getThreshold());
        Integer max = threshold.getThreshold();
        QueryResult queryResult = influxDB.query(query);
        System.out.println("原始结果为：" + queryResult);
        // 获取查询结果
        List<QueryResult.Result> results = queryResult.getResults();
        if (results == null) {
            return null;
        }
        // 多个sql用分号隔开，因本次查询只有一个sql，所以取第一个就行
        QueryResult.Result result = results.get(0);
        List<QueryResult.Series> seriesList = result.getSeries();
        List<Double> numList = new ArrayList<>(10);
        if(seriesList==null){
            return numList;
        }
        for (QueryResult.Series series : seriesList) {
            if (series == null) {
                return numList;
            }
            System.out.println("结果数量为：" + (series.getValues() == null ?
                    0 : series.getValues().size()));
            System.out.println("name ==>> " + series.getName());
            System.out.println("values ==>> " + series.getValues());
            series.getValues().forEach(valueData -> {
                numList.add(Double.parseDouble(valueData.get(2).toString()));
                double tem = Double.parseDouble(valueData.get(2).toString());
                if(max<(int) tem){
                    Events events = new Events();
                    events.setIp(ip);
                    events.setPort(port);
                    events.setCurrentTime(new Date());
                    events.setEventName("interface:"+interfaceName);
                    events.setTarget(tem+"");
                    log.info(interfaceName+"调用频次过高 触发报警");
                    eventsService.insert(events);
                }
            });
        }
        return numList;
    }
}
