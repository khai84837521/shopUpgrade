package com.shopUpdate.mapper;

import com.shopUpdate.domain.MailDTO;

public interface MailMapper {

    //이메일 조회
    public MailDTO mailInfoSelect(MailDTO mailDTO);

    //mail 테이블 데이터 삽입
    public int mailCodeInsert(MailDTO mailDTO);

    //이메일 코드 수정
    public int mailCodeUpdate(MailDTO mailDTO);
}
