package com.wzxlq.controller;

import com.wzxlq.dto.ResponseDto;
import com.wzxlq.entity.Memory;
import org.influxdb.InfluxDB;
import org.influxdb.dto.BoundParameterQuery;
import org.influxdb.dto.Query;
import org.influxdb.dto.QueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloController {

    @Autowired
    private InfluxDB influxDB;

    @Value("${spring.influx.database}")
    private String database;
    @Value("${server.address}")
    private String address;

    @GetMapping("/getMemory")
    public ResponseDto getMemory(String ip,String port) {
        System.out.println("---开始查询数据---");
        // InfluxDB支持分页查询,因此可以设置分页查询条件
        int page = 1; // 起始页（从0开始）
        int pageSize = 10;  // 每页条目数
        String pageQuery = " LIMIT " + pageSize + " OFFSET " + (page - 1) * pageSize;
        //String queryCondition = "";  //查询条件暂且为空
        // 此处查询所有内容,如果
        //String queryCmd = "SELECT * FROM "
        //        // 要指定从 RetentionPolicyName.measurement中查询指定数据,默认的策略可以不加；
        //        // + 策略name + "." + measurement
        //        + "jvm_memory_used"
        //        // 添加查询条件(注意查询条件选择tag值,选择field数值会严重拖慢查询速度)
        //        + queryCondition
        //        // 查询结果需要按照时间排序
        //        + " ORDER BY time DESC"
        //        // 添加分页查询条件
        //        + pageQuery;
        Query queryPsOldGen = BoundParameterQuery.QueryBuilder.newQuery("SELECT * FROM jvm_memory_used WHERE id = $id and app = $app and port = $port" + " ORDER BY time DESC"
                + pageQuery)
                .bind("id", "PS Old Gen")
                .bind("app",ip)
                .bind("port",port)
                .create();
        Query queryPsEdenSpace = BoundParameterQuery.QueryBuilder.newQuery("SELECT * FROM jvm_memory_used WHERE id = $id and app = $app and port = $port" + " ORDER BY time DESC"
                + pageQuery)
                .bind("id", "PS Eden Space")
                .bind("app",ip)
                .bind("port",port)
                .create();
        // 开始查询
        //QueryResult queryResult = influxDB.query(new Query(queryCmd, database));
        List<Double> oldList = startQuery(queryPsOldGen);
        List<Double> edenList = startQuery(queryPsEdenSpace);
        Memory memory = new Memory();
        memory.setEdenList(edenList);
        memory.setOldList(oldList);
        ResponseDto responseDto = new ResponseDto();
        responseDto.setContent(memory);
        return responseDto;
    }

    public List<Double> startQuery(Query query) {
        QueryResult queryResult = influxDB.query(query);
        //System.out.println("原始结果为：" + queryResult);
        // 获取查询结果
        List<QueryResult.Result> results = queryResult.getResults();
        if (results == null) {
            return null;
        }
        // 多个sql用分号隔开，因本次查询只有一个sql，所以取第一个就行
        QueryResult.Result result = results.get(0);
        List<QueryResult.Series> seriesList = result.getSeries();
        List<Double> numList = new ArrayList<>();
        for (QueryResult.Series series : seriesList) {
            if (series == null) {
                return null;
            }
            System.out.println("结果数量为：" + (series.getValues() == null ?
                    0 : series.getValues().size()));
            System.out.println("name ==>> " + series.getName());
            System.out.println("values ==>> " + series.getValues());
            series.getValues().forEach(valueData -> {
                // 直接查询出来的是科学计数法，需要转换为Long类型的数据
                BigDecimal decimalTime = new BigDecimal(valueData.get(5).toString());
                numList.add(Double.parseDouble(String.format("%.3f", bitToMb(decimalTime.longValue()))));
            });
        }
        return numList;
    }

    public double bitToMb(long bit) {
        return bit / 8.0 / 1024 / 1024;
    }
}