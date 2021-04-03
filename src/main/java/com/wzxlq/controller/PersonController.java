package com.wzxlq.controller;

import com.wzxlq.entity.Person;
import com.wzxlq.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Person)表控制层
 *
 * @author makejava
 * @since 2020-10-17 10:32:42
 */
@RestController
@Slf4j
@RequestMapping("person")
public class PersonController {
    /**
     * 服务对象
     */
    @Resource
    private PersonService personService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Person selectOne(Integer id) {
        return this.personService.queryById(id);
    }
    @GetMapping("/insertPerson")
    public Person insertPerson(){
        Person person = new Person();
        person.setId(2);
        person.setName("wu");
        person.setAge(0);
        return personService.insert(person);
    }

}