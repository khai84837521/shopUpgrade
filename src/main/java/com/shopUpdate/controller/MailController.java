package com.shopUpdate.controller;

import com.shopUpdate.domain.MailDTO;
import com.shopUpdate.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import javax.mail.internet.MimeMessage;

@Controller
public class MailController {

    @Inject
    private MailService mailService;

    @Autowired
    private JavaMailSenderImpl mailSender;


    @PostMapping("/sendMail")
    @ResponseBody
    public String sendMail(MailDTO mailDTO){
        System.out.println("MailController::sendMail");
        int result = 0;

        if(mailService.emailCheck(mailDTO) == null){
            result = mailService.mailCodeInsert(mailDTO);
        }else{
            result = mailService.mailCodeUpdate(mailDTO);
        }
        if(result == 1 ){
            // 메일을 보내기위한 MailDTO 세팅
            mailDTO.setSenderMail("khai84837521@gmail.com");
            mailDTO.setReceiveMail(mailDTO.getEmail());
            mailDTO.setSubject("GHSHOP : 인증코드입니다.");
            mailDTO.setMessage("인증코드는 : " + mailDTO.getMailCode());

            // 메일을 보내기위한 객체 세팅
            final MimeMessagePreparator preparator = new MimeMessagePreparator() {
                @Override
                public void prepare(MimeMessage mimeMessage) throws Exception {
                    final MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
                        System.out.println(mailDTO.getSenderMail());
                        helper.setFrom(mailDTO.getSenderMail());
                        helper.setTo(mailDTO.getEmail());
                        helper.setSubject(mailDTO.getSubject());
                        helper.setText(mailDTO.getMessage());
                    }
                };
            //세팅된 객체를 통해 메일 발송
            mailSender.send(preparator);
            }
        System.out.println("success, send mail");
        return result == 1 ? "true" : "false";
        }

    @PostMapping("/emailCodeCheck")
    @ResponseBody
    public String emailCodeCheck(MailDTO mailDTO){
        System.out.println("MailController::emailCodeCheck");
        String result = "false";
        if(mailService.emailCodeCheck(mailDTO).equals(mailDTO.getMailCode())){
            return result = "true";
        }else{
            return result;
        }

    }
}
