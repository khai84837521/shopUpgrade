package com.shopUpdate.service;

import com.shopUpdate.domain.MemberDTO;
import com.shopUpdate.mapper.MemberMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class MemberServiceImpl implements MemberService{

    @Inject
    MemberMapper memberMapper;

    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter fommetter = DateTimeFormatter.ofPattern("YYYY/MM/dd hh:mm:ss");
    String formatedNow = now.format(fommetter);

    @Override
    public MemberDTO loginPro(MemberDTO memberDTO) {
        System.out.println("MemberServiceImpl::loginPro");
        return memberMapper.loginPro(memberDTO);
    }

    @Override
    public String userIdCheck(String userId) {
        System.out.println("MemberServiceImpl::userIdCheck");
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setUserInfo(userId);
        memberDTO.setColumn("memId");
        return memberMapper.userSelectOne(memberDTO);
    }

    @Override
    @Transactional
    public int memberInsert(MemberDTO memberDTO) {
        System.out.println("MemberServiceImpl::memberInsert");
        memberDTO.setDate(formatedNow);
        return memberMapper.insertMember(memberDTO) ;
    }

    @Override
    public String userEmailCheck(String email) {
        System.out.println("MemberServiceImpl::userEmailCheck");
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setUserInfo(email);
        memberDTO.setColumn("email");
        return memberMapper.userSelectOne(memberDTO);
    }

    @Override
    public String findId(MemberDTO memberDTO) {
        System.out.println("MemberServiceImpl::findId");
        return memberMapper.findId(memberDTO);
    }

    @Override
    public int deleteMember(MemberDTO memberDTO) {
        System.out.println("MemberServiceImpl::deleteMember");
        return memberMapper.deleteMember(memberDTO);
    }

    @Override
    public int memberPassChange(MemberDTO memberDTO) {
        System.out.println("MemberServiceImpl::memberPassChange");
        return memberMapper.memberPassChange(memberDTO);
    }
}
