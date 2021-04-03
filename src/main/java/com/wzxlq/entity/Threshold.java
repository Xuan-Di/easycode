package com.wzxlq.entity;

import java.io.Serializable;

/**
 * (Threshold)实体类
 *
 * @author makejava
 * @since 2021-03-30 13:24:56
 */
public class Threshold implements Serializable {

    private static final long serialVersionUID = -71668594500745367L;

            
    private Integer id;

            
    private String ip;

            
    private String interfaceName;

            
    private Integer threshold;

        
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
        
    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }
        
    public Integer getThreshold() {
        return threshold;
    }

    public void setThreshold(Integer threshold) {
        this.threshold = threshold;
    }

}