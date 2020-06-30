package com.javamm.mailserver;

import com.javamm.vhr.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Date;

@Component
public class RecieveMail {

    private final static Logger log =LoggerFactory.getLogger(RecieveMail.class);
    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    MailProperties mailProperties;

    @Autowired
    TemplateEngine templateEngine;

    @RabbitListener(queues="javamm.mail")
    public void handle(Employee employee){
        log.info("RecieveMail.class ..."+employee.toString());
        //收到消息，发送邮件
        MimeMessage message = javaMailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message);

        try {
            helper.setTo(employee.getEmail());
            String from = mailProperties.getUsername();
            helper.setFrom(from);
            helper.setSubject("入职欢迎");
            helper.setSentDate(new Date());
            Context context = new Context();
            context.setVariable("name",employee.getName());
            context.setVariable("positionName",employee.getPosition().getName());
            context.setVariable("joblevelName",employee.getJobLevel().getName());
            context.setVariable("departmentName",employee.getDepartment().getName());

            String mail = templateEngine.process("mail", context);
            helper.setText(mail,true);
            javaMailSender.send(message);
        } catch (MessagingException e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
    }
}
