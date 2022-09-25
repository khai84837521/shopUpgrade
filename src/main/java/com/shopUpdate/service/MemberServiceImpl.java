package com.shopUpdate.service;

import com.shopUpdate.dao.MemberDAO;
import com.shopUpdate.domain.MemberDTO;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class MemberServiceImpl implements MemberService{

    @Inject
    MemberDAO memberDAO;
    @Inject
    MemberDTO memberDTO;

    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter fommetter = DateTimeFormatter.ofPattern("YYYY/MM/dd hh:mm:ss");
    String formatedNow = now.format(fommetter);

    @Override
    public MemberDTO loginPro(MemberDTO memberDTO) {
        System.out.println("MemberServiceImpl::loginPro");
        return memberDAO.loginPro(memberDTO);
    }

    @Override
    public String userIdCheck(String userId) {
        System.out.println("MemberServiceImpl::userIdCheck");
        memberDTO.setUserInfo(userId);
        memberDTO.setColumn("memId");
        return memberDAO.userSelectOne(memberDTO);
    }

    @Override
    public int memberInsert(MemberDTO memberDTO) {
        System.out.println("MemberServiceImpl::memberInsert");
        memberDTO.setDate(formatedNow);
        return memberDAO.insertMember(memberDTO);
    }

    @Override
    public String userEmailCheck(String email) {
        System.out.println("MemberServiceImpl::userEmailCheck");
        memberDTO.setUserInfo(email);
        memberDTO.setColumn("email");
        return memberDAO.userSelectOne(memberDTO);
    }

    @Override
    public String findId(MemberDTO memberDTO) {
       System.out.println("MemberServiceImpl::findId");
       return memberDAO.findId(memberDTO);
    }

    @Override
    public int deleteMember(MemberDTO memberDTO) {
        System.out.println("MemberServiceImpl::deleteMember");
        return memberDAO.deleteMember(memberDTO);
    }

    @Override
    public int memberPassChange(MemberDTO memberDTO) {
        System.out.println("MemberServiceImpl::memberPassChange");
        return memberDAO.memberPassChange(memberDTO);
    }
}
