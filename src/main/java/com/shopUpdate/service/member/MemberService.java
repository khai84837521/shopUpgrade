package com.shopUpdate.service.member;

import com.shopUpdate.domain.MemberDTO;



public interface MemberService {
    MemberDTO loginPro(MemberDTO memberDTO);
    String userIdCheck(String userId);
    int memberInsert(MemberDTO memberDTO);
    String userEmailCheck(String email);
    String findId(MemberDTO memberDTO);
    int deleteMember(MemberDTO memberDTO);
    int memberPassChange(MemberDTO memberDTO);
}
