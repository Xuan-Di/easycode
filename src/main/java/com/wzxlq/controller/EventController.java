package com.wzxlq.controller;

import com.wzxlq.dto.ResponseDto;
import com.wzxlq.entity.Event;
import org.influxdb.InfluxDB;
import org.influxdb.dto.BoundParameterQuery;
import org.influxdb.dto.Query;
import org.influxdb.dto.QueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Package: com.wzxlq.controller
 * @ClassName: EventController
 * @Author: 王照轩
 * @CreateTime: 2021/3/24 14:42
 * @Description:
 */

@RestController
public class EventController {
    @Autowired
    private InfluxDB influxDB;

    @Value("${spring.influx.database}")
    private String database;

    @Value("${server.address}")
    private String address;

    @GetMapping("selectEvent")
    public ResponseDto selectEvent(String ip,String port) {
        int page = 1; // 起始页（从0开始）
        int pageSize = 10;  // 每页条目数
        String pageQuery = " LIMIT " + pageSize + " OFFSET " + (page - 1) * pageSize;
        Query queryDebug = BoundParameterQuery.QueryBuilder
                .newQuery("SELECT sum(\"value\") FROM logback_events WHERE level = $level and app = $app and port = $port" + " ORDER BY time DESC"
                        + pageQuery)
                .bind("level", "debug")
                .bind("app", ip)
                .bind("port", port)
                .create();
        Query queryWarn = BoundParameterQuery.QueryBuilder
                .newQuery("SELECT sum(\"value\") FROM logback_events WHERE level = $level and app = $app and port = $port" + " ORDER BY time DESC"
                        + pageQuery)
                .bind("level", "warn")
                .bind("app", ip)
                .bind("port", port)
                .create();
        Query queryError = BoundParameterQuery.QueryBuilder
                .newQuery("SELECT sum(\"value\") FROM logback_events WHERE level = $level and app = $app and port = $port" + " ORDER BY time DESC"
                        + pageQuery)
                .bind("level", "error")
                .bind("app", ip)
                .bind("port", port)
                .create();
        Event event = new Event();
        event.setDebug(startQuery(queryDebug));
        event.setWarn(startQuery(queryWarn));
        event.setError(startQuery(queryError));
        ResponseDto responseDto = new ResponseDto();
        responseDto.setContent(event);
        return responseDto;
    }

    public String startQuery(Query query) {
        QueryResult queryResult = influxDB.query(query);
        //System.out.println("原始结果为：" + queryResult);
        // 获取查询结果
        List<QueryResult.Result> results = queryResult.getResults();
        if (results == null) {
            return "0";
        }
        // 多个sql用分号隔开，因本次查询只有一个sql，所以取第一个就行
        QueryResult.Result result = results.get(0);
        List<QueryResult.Series> seriesList = result.getSeries();
        String res = "0";
        for (QueryResult.Series series : seriesList) {
            if (series == null) {
                return "0";
            }
            System.out.println("结果数量为：" + (series.getValues() == null ?
                    0 : series.getValues().size()));
            System.out.println("name ==>> " + series.getName());
            System.out.println("values ==>> " + series.getValues());
            res = series.getValues().get(0).get(1).toString();
            return res;
        }
        return "0";
    }
}