package com.wzxlq.controller;

import com.wzxlq.entity.Microservice;
import com.wzxlq.service.MicroserviceService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Microservice)表控制层
 *
 * @author makejava
 * @since 2021-03-31 15:21:30
 */
@RestController
@RequestMapping("microservice")
public class MicroserviceController {
    /**
     * 服务对象
     */
    @Resource
    private MicroserviceService microserviceService;


    @PostMapping("insert")
    public Microservice insertOne(@RequestBody Microservice microservice) {
        return microserviceService.insert(microservice);
    }

    @GetMapping("delete")
    public boolean deleteByIp(String ip){
        return microserviceService.deleteById(ip);
    }

}