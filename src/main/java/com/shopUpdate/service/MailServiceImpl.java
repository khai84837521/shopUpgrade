package com.shopUpdate.service;

import com.shopUpdate.dao.MailDAO;
import com.shopUpdate.domain.MailDTO;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;

@Service
public class MailServiceImpl implements MailService{

    @Inject
    private MailDAO mailDAO;
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter fommetter = DateTimeFormatter.ofPattern("YYYY/MM/dd hh:mm:ss");
    String formatedNow = now.format(fommetter);

    @Override
    public MailDTO emailCheck(MailDTO mailDTO) {
        System.out.println("MailServiceImpl::emailCheck");
        return mailDAO.emailCheck(mailDTO);
    }

    public String CodeMaker(){
        Random random = new Random();

        String malCode = "";

        for(int i=0; i<6; i++){
            int num = random.nextInt(3);
            switch (num) {
                case 0 :
                    malCode += (char)(random.nextInt(26)+97);
                    break;
                case 1:
                    malCode += (char)(random.nextInt(26)+65);
                    break;
                case 2:
                    malCode += (int)random.nextInt(10);
                    break;
            }
        }
        return malCode;
    }


    @Override
    public int mailCodeInsert(MailDTO mailDTO) {
        System.out.println("MailServiceImpl::mailCodeInsert");
        mailDTO.setMailCreateDt(formatedNow);
        mailDTO.setMailCode(CodeMaker());
        return mailDAO.mailCodeInsert(mailDTO);
    }

    @Override
    public int mailCodeUpdate(MailDTO mailDTO) {
        System.out.println("MailServiceImpl::mailCodeUpdate");
        mailDTO.setMalUpdateDt(formatedNow);
        mailDTO.setMailCode(CodeMaker());
        return mailDAO.mailCodeUpdate(mailDTO);
    }

    @Override
    public String emailCodeCheck(MailDTO mailDTO) {
        System.out.println("MailServiceImpl::emailCodeCheck");
        mailDTO.setColumn("mailCode");
        return mailDAO.MailSelectOne(mailDTO);
    }
}
