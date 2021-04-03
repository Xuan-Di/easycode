package com.wzxlq.entity;

import java.io.Serializable;

/**
 * (Student)实体类
 *
 * @author makejava
 * @since 2020-10-17 11:00:05
 */
public class Student implements Serializable {

    private static final long serialVersionUID = -52860555118436288L;

            
    private Integer stuno;

            
    private String stuname;

            
    private Integer stuage;

            
    private String graname;

            
    private Integer stusex;

            
    private Integer cardid;

            
    private Integer classid;

        
    public Integer getStuno() {
        return stuno;
    }

    public void setStuno(Integer stuno) {
        this.stuno = stuno;
    }
        
    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }
        
    public Integer getStuage() {
        return stuage;
    }

    public void setStuage(Integer stuage) {
        this.stuage = stuage;
    }
        
    public String getGraname() {
        return graname;
    }

    public void setGraname(String graname) {
        this.graname = graname;
    }
        
    public Integer getStusex() {
        return stusex;
    }

    public void setStusex(Integer stusex) {
        this.stusex = stusex;
    }
        
    public Integer getCardid() {
        return cardid;
    }

    public void setCardid(Integer cardid) {
        this.cardid = cardid;
    }
        
    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }

}