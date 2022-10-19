package com.shopUpdate.service.member;

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


    @Override
    public MemberDTO loginPro(MemberDTO memberDTO) {
        return memberMapper.loginPro(memberDTO);
    }

    @Override
    public String userIdCheck(String userId) {
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setUserInfo(userId);
        memberDTO.setColumn("memId");
        return memberMapper.userSelectOne(memberDTO);
    }

    @Override
    @Transactional
    public int memberInsert(MemberDTO memberDTO) {
        return memberMapper.insertMember(memberDTO) ;
    }

    @Override
    public String userEmailCheck(String email) {
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setUserInfo(email);
        memberDTO.setColumn("email");
        return memberMapper.userSelectOne(memberDTO);
    }

    @Override
    public String findId(MemberDTO memberDTO) {
        return memberMapper.findId(memberDTO);
    }

    @Override
    public int deleteMember(MemberDTO memberDTO) {
        return memberMapper.deleteMember(memberDTO);
    }

    @Override
    public int memberPassChange(MemberDTO memberDTO) {
        return memberMapper.memberPassChange(memberDTO);
    }
}
