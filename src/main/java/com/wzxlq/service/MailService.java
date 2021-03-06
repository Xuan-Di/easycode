package com.wzxlq.service;

import com.wzxlq.dto.MailDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

/**
 * @author 王照轩
 * @date 2020/2/3 - 22:14
 */
@Service
@Slf4j
@EnableAsync
public class MailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private Environment env;


    /**
     * 发送简单文本文件
     */
    @Async
    public void sendSimpleEmail(final MailDto dto) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(env.getProperty("mail.send.from"));
            message.setTo(dto.getTos());
            message.setSubject(dto.getSubject());
            message.setText(dto.getContent());
            mailSender.send(message);

            log.info("发送简单文本文件-发送成功!");
        } catch (Exception e) {
            log.error("发送简单文本文件-发生异常： ", e.fillInStackTrace());
        }
    }

    /**
     * 发送花哨邮件
     *
     * @param dto
     */
    @Async
    public void sendHTMLMail(final MailDto dto) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "utf-8");
            messageHelper.setFrom(env.getProperty("mail.send.from"));
            messageHelper.setTo(dto.getTos());
            messageHelper.setSubject(dto.getSubject());
            messageHelper.setText(dto.getContent(), true);

            mailSender.send(message);
            log.info("发送花哨邮件-发送成功!");
        } catch (Exception e) {
            log.error("发送花哨邮件-发生异常： ", e.fillInStackTrace());
        }
    }
}
