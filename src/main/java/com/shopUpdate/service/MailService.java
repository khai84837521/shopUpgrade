package com.shopUpdate.service;


import com.shopUpdate.domain.MailDTO;

import javax.inject.Inject;

public interface MailService {

    public MailDTO emailCheck(MailDTO mailDTO);

    public int mailCodeInsert(MailDTO mailDTO);

    public int mailCodeUpdate(MailDTO mailDTO);

    public String emailCodeCheck(MailDTO mailDTO);
}
