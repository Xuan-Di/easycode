package com.wzxlq.controller;

import com.wzxlq.dto.MailDto;
import com.wzxlq.entity.Student;
import com.wzxlq.service.MailService;
import com.wzxlq.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * (Student)表控制层
 *
 * @author makejava
 * @since 2020-10-17 11:00:05
 */
@RestController
@Slf4j
@RequestMapping("student")
public class StudentController {
    /**
     * 服务对象
     */
    @Resource
    private StudentService studentService;

    @Resource
    private MailService mailService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Student selectOne(Integer id,HttpServletRequest request) {
        request.getSession().setAttribute("session",id);
        log.warn("studentId:" + id);
        return this.studentService.queryById(id);
    }

    //@PostMapping("sendMsm")
    public String sendMsm() {
        log.info("alert");
        MailDto mailDto = new MailDto();
        mailDto.setSubject("api调用告警!");
        mailDto.setContent("api调用告警!");
        mailDto.setTos(new String[]{new String("1099393970@qq.com")});
        mailService.sendSimpleEmail(mailDto);
        return "true";
    }

    @GetMapping("logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "success";
    }
}