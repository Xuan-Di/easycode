package com.wzxlq.controller;

import com.wzxlq.dto.ResponseDto;
import com.wzxlq.entity.Events;
import com.wzxlq.service.EventsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Events)表控制层
 *
 * @author makejava
 * @since 2021-04-03 16:08:50
 */
@RestController
@RequestMapping("events")
public class EventsController {
    /**
     * 服务对象
     */
    @Resource
    private EventsService eventsService;

    @GetMapping("queryByIpAndPort")
    public ResponseDto queryByIpAndPort(String ip,String port) {
        List<Events> events = eventsService.queryByIpAndPort(ip, port);
        ResponseDto responseDto = new ResponseDto();
        responseDto.setContent(events);
        return responseDto;
    }

}