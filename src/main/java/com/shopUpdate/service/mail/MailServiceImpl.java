package com.shopUpdate.service.mail;

import com.shopUpdate.domain.MailDTO;
import com.shopUpdate.mapper.MailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.mail.internet.MimeMessage;
import java.util.Random;

@Service
public class MailServiceImpl implements MailService{

    @Inject
    private MailMapper mailMapper;

    @Autowired
    private JavaMailSenderImpl mailSender;

    /**
     * 메일보내기
     * @param mailDTO
     * @return 메일 발송 성공 여부
     */
    @Override
    public int sendMail(MailDTO mailDTO) {
        int result = 0;
        if(mailMapper.mailInfoSelect(mailDTO) == null){
            mailDTO.setMailCode(CodeMaker());
            result = mailMapper.mailCodeInsert(mailDTO);
        }else{
            mailDTO.setMailCode(CodeMaker());
            result = mailMapper.mailCodeUpdate(mailDTO);
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
                    helper.setFrom(mailDTO.getSenderMail());
                    helper.setTo(mailDTO.getEmail());
                    helper.setSubject(mailDTO.getSubject());
                    helper.setText(mailDTO.getMessage());
                }
            };
            //세팅된 객체를 통해 메일 발송
            mailSender.send(preparator);
        }


        return result;
    }

    /**
     * 이메일 코드 체크
     * @param mailDTO
     * @return 조회된 이메일 코드
     */
    @Override
    public int emailCodeCheck(MailDTO mailDTO) {
        int result = 0;
        String inputCode = mailDTO.getMailCode();
        String selectCode = mailMapper.mailInfoSelect(mailDTO).getMailCode();

        if(inputCode.equals(selectCode)){
            result = 1;
        }

        return result;
    }

    /**
     * 이메일 랜덤 코드 생성
     * @return 생성된 이메일 코드
     */
    public String CodeMaker(){
        Random random = new Random();

        String mailCode = "";

        for(int i=0; i<6; i++){
            int num = random.nextInt(3);
            switch (num) {
                case 0 :
                    mailCode += (char)(random.nextInt(26)+97);
                    break;
                case 1:
                    mailCode += (char)(random.nextInt(26)+65);
                    break;
                case 2:
                    mailCode += (int)random.nextInt(10);
                    break;
            }
        }
        return mailCode;
    }


}
