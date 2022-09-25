package com.shopUpdate.dao;

import com.shopUpdate.domain.MailDTO;

public interface MailDAO {

    public MailDTO emailCheck(MailDTO mailDTO);

    public String MailSelectOne(MailDTO mailDTO);

    public int mailCodeInsert(MailDTO mailDTO);
    public int mailCodeUpdate(MailDTO mailDTO);
}
