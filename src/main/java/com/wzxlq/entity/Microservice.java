package com.wzxlq.entity;

import java.io.Serializable;

/**
 * (Microservice)实体类
 *
 * @author makejava
 * @since 2021-03-31 15:21:28
 */
public class Microservice implements Serializable {

    private static final long serialVersionUID = -74378053336032690L;

            
    private String ip;

            
    private String port;

            
    private String serveName;

        
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
        
    public String getServeName() {
        return serveName;
    }

    public void setServeName(String serveName) {
        this.serveName = serveName;
    }

}