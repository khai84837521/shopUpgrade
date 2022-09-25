package com.shopUpdate.domain;

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


    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSenderMail() {
        return senderMail;
    }

    public void setSenderMail(String senderMail) {
        this.senderMail = senderMail;
    }

    public String getReceiveMail() {
        return receiveMail;
    }

    public void setReceiveMail(String receiveMail) {
        this.receiveMail = receiveMail;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMalUpdateDt() {
        return malUpdateDt;
    }

    public void setMalUpdateDt(String malUpdateDt) {
        this.malUpdateDt = malUpdateDt;
    }

    public String getMailCreateDt() {
        return mailCreateDt;
    }

    public void setMailCreateDt(String mailCreateDt) {
        this.mailCreateDt = mailCreateDt;
    }

    public int getMailType() {
        return mailType;
    }

    public void setMailType(int mailType) {
        this.mailType = mailType;
    }

    public String getMailCode() {
        return mailCode;
    }

    public void setMailCode(String mailCode) {
        this.mailCode = mailCode;
    }

    public int getMailStatus() {
        return mailStatus;
    }

    public void setMailStatus(int mailStatus) {
        this.mailStatus = mailStatus;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString(){
        return "MailDTO [senderName=" + senderName + ", senderMail=" + senderMail + ", receiveMail=" + receiveMail
                + ", subject=" + subject + ", message=" + message + "]";
    }
}
