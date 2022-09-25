package com.shopUpdate.service;

import com.shopUpdate.domain.MemberDTO;



public interface MemberService {
    public MemberDTO loginPro(MemberDTO memberDTO);
    public String userIdCheck(String userId);
    public int memberInsert(MemberDTO memberDTO);
    public String userEmailCheck(String email);
    public String findId(MemberDTO memberDTO);
    public int deleteMember(MemberDTO memberDTO);
    public int memberPassChange(MemberDTO memberDTO);
}
