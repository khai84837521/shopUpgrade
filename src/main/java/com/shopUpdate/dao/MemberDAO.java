package com.shopUpdate.dao;


import com.shopUpdate.domain.MemberDTO;

public interface MemberDAO {

    public MemberDTO loginPro(MemberDTO memberDTO);
    public String userSelectOne(MemberDTO memberDTO);
    public int insertMember(MemberDTO memberDTO);
    public String findId(MemberDTO memberDTO);
    public int deleteMember(MemberDTO memberDTO);
    public int memberPassChange(MemberDTO memberDTO);
}
