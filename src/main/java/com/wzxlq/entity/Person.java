package com.wzxlq.entity;

import java.io.Serializable;

/**
 * (Person)实体类
 *
 * @author makejava
 * @since 2020-10-17 10:32:40
 */
public class Person implements Serializable {

    private static final long serialVersionUID = -73243889016958227L;

            
    private Integer id;

            
    private String name;

            
    private Integer age;

        
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
        
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
        
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}