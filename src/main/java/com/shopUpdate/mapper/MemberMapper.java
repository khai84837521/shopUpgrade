package com.shopUpdate.mapper;

import com.shopUpdate.domain.MemberDTO;

public interface MemberMapper {
    String userSelectOne(MemberDTO memberDTO);
    MemberDTO loginPro(MemberDTO memberDTO);
    int insertMember(MemberDTO memberDTO);
    String findId(MemberDTO memberDTO);
    int deleteMember(MemberDTO memberDTO);
    int memberPassChange(MemberDTO memberDTO);
}
