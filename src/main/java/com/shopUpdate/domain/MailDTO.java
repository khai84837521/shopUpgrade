package com.shopUpdate.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MailDTO {
    private int mailType;
    private String mailCode;
    private int mailStatus;
    private String email;
    private String mailCreateDt;
    private String malUpdateDt;

    private String senderName;
    private String senderMail;
    private String receiveMail;
    private String subject;
    private String message;

    private String column;

}
