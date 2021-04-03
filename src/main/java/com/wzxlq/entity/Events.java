package com.wzxlq.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Events)实体类
 *
 * @author makejava
 * @since 2021-04-03 16:08:45
 */
public class Events implements Serializable {

    private static final long serialVersionUID = -76933050666270266L;

            
    private Integer id;

            
    private String ip;

            
    private String port;

            
    private String eventName;

            
    private String target;

            
    private Date currentTime;

        
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
        
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
        
    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }
        
    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
        
    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }
        
    public Date getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(Date currentTime) {
        this.currentTime = currentTime;
    }

}