package com.wzxlq.easycode;

import com.wzxlq.entity.Events;
import com.wzxlq.service.EventsService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
class EasycodeApplicationTests {
    @Resource
    private EventsService eventsService;

    @Test
    void contextLoads() throws ParseException {

        System.out.println(new Date());
        Events events = new Events();
        events.setIp("0.0.0.0");
        events.setPort("800");
        events.setCurrentTime(new Date());
        events.setEventName("interface:");
        events.setTarget("xx");
        eventsService.insert(events);
    }

}
