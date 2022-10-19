package com.shopUpdate.controller;

import com.shopUpdate.domain.MailDTO;
import com.shopUpdate.service.mail.MailService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;

@Controller
public class MailController {

    @Inject
    private MailService mailService;

    /**
     * 인증 메일 보내기
     * @param mailDTO
     * @return 메일 발송 성공 여부 (발송 성공 시 result = 1, 발송 실패시 result = 0)
     */
    @PostMapping("/sendMail")
    @ResponseBody
    public String sendMail(MailDTO mailDTO){
        return mailService.sendMail(mailDTO) == 1 ? "true" : "false";
        }

    /**
     * 이메일 코드 체크
     * @param mailDTO
     * @return 이메일 코드 일치 여부 (일치시 result = 1, 불일치시 result = 0)
     */
    @PostMapping("/emailCodeCheck")
    @ResponseBody
    public String emailCodeCheck(MailDTO mailDTO){
        return mailService.emailCodeCheck(mailDTO) == 1 ? "true" : "false";
    }
}
