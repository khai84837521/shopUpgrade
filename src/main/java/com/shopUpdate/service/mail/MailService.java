package com.shopUpdate.service.mail;


import com.shopUpdate.domain.MailDTO;

import javax.inject.Inject;

public interface MailService {

    public int emailCodeCheck(MailDTO mailDTO);

    public int sendMail(MailDTO mailDTO);
}
