package com.shopUpdate.controller;

import com.shopUpdate.common.enums.Message;
import com.shopUpdate.common.enums.RedirectUrl;
import com.shopUpdate.domain.MemberDTO;
import com.shopUpdate.exception.BaseException;
import com.shopUpdate.exception.ErrorCode;
import com.shopUpdate.service.member.MemberService;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

@Controller
public class MemberController {
    @Inject
    private MemberService memberService;

    /**
     * 회원가입 페이지 매핑
     * @return 메세지 페이지 (msgBox.jsp)
     */
    @GetMapping("/join")
    public String join(){
        return "/member/join";
    }

    @PostMapping("/joinPro")
    public String joinPro(MemberDTO memberDTO, Model model){
        try {
            memberService.memberInsert(memberDTO);
        } catch (Exception e) {
            throw new BaseException(ErrorCode.MEMBER_JOIN_FAIL, RedirectUrl.MEMBER_JOIN.getUrl());
        }
        model.addAttribute("msg", Message.MEMBER_JOIN_SUCCESS.getMessage());
        model.addAttribute("url", RedirectUrl.MAIN.getUrl());
        return "msgBox";
    }

    /**
     * 중복 아이디 체크
     * @param checkId
     * @return 아이디 중복 여부 (Y or N)
     */
    @PostMapping("/joinIdCheck")
    @ResponseBody
    public String joinIdCheck(@RequestParam(name = "id") String checkId){
        String checkedId = memberService.userIdCheck(checkId);
        String result = "N";
        if(checkedId == null){
            result = "Y";
            return result;
        }else{
            return result;
        }


    }

    /**
     * 로그인 페이지 매핑
     * @return 로그인 페이지
     */
    @GetMapping("/login")
    public String login(){
        return "/member/login";
    }


    /**
     * 로그인
     * @param memberDTO
     * @param model
     * @param session
     * @return 매세지 페이지 (msgBox.jsp)
     * @throws Exception 
     *         등록되지 않은 아이디 및 비밀번호 일 경우,
     *         아이디/비밀번호가 일치하지 않을 경우 
     */
    @PostMapping("/loginPro")
    public String loginPro(MemberDTO memberDTO, Model model, HttpSession session) throws Exception {

        memberDTO = memberService.loginPro(memberDTO);
        if(memberDTO == null) throw new BaseException(ErrorCode.MEMBER_LOGIN_FAIL, RedirectUrl.LOGIN.getUrl());
        session.setAttribute(MemberDTO.SESSION_NAME, memberDTO);
        model.addAttribute("url", RedirectUrl.MAIN.getUrl());
        return "msgBox";
    }

    /**
     * 로그아웃
     * @param session
     * @param model
     * @return 메세지 페이지 (msgBox.jsp)
     */
    @GetMapping("/logout")
    public String logout(@NotNull HttpSession session, @NotNull Model model){
        session.invalidate();
        model.addAttribute("msg", Message.MEMBER_LOGOUT );
        model.addAttribute("url", RedirectUrl.MAIN.getUrl());
        return "msgBox";
    }

    /**
     * 이메일 중복 체크
     * @param email
     * @return 이메일 중복 여부(사용가능한 이메일 : true, 중복된 이메일 : false)
     */
    @PostMapping("/emailCheck")
    @ResponseBody
    public String emailCheck(String email){
        int result = 0;
        if(memberService.userEmailCheck(email) == null){
            result = 1;
        }
        return result == 1 ? "true" : "false";
    }

    /**
     * 아이디 찾기 진행 페이지 매핑
     * @return 아이디 찾기 진행 페이지
     */
    @GetMapping("/findId")
    public String findId(){
        return "member/findId";
    }

    /**
     * 찾은 아이디 제공 페이지 매핑
     * @param memberDTO
     * @param model
     * @return 찾은 아이디 제공 페이지
     */
    @PostMapping("/findIdOk")
    public String findIdOk(MemberDTO memberDTO, @NotNull Model model){
        String memberId = memberService.findId(memberDTO);
        model.addAttribute("memberId",  memberId);
        return "member/findIdOk";
    }

    /**
     * 회원탈퇴 진행 페이지 매핑 
     * @return 회원탈퇴 진행 페이지
     */
    @GetMapping("/withdrawal")
    public String withdrawal(HttpSession session){
        if(session.getAttribute(MemberDTO.SESSION_NAME) == null) throw new BaseException(ErrorCode.MEMEBER_SESSION_NULL, RedirectUrl.MAIN.getUrl());
        return "member/memberDelete";
    }

    /**
     * 회원탈퇴
     * @param memberDTO
     * @return 세션이 삭제된 메인페이지
     */
    @PostMapping("/withdrawalPro")
    public String withdrawal(MemberDTO memberDTO, HttpSession session){
        memberService.deleteMember(memberDTO);
        session.invalidate();
        return "main";
    }

    /**
     * 비밀번호 변경 페이지 매핑
     * @return 비밀번호 변경 페이지
     */
    @GetMapping("/passChange")
    public String passChange(HttpSession session){
        if(session.getAttribute(MemberDTO.SESSION_NAME) == null )throw new BaseException(ErrorCode.MEMEBER_SESSION_NULL, RedirectUrl.MAIN.getUrl());
        return "member/findPass";
    }

    /**
     * 비밀번호 변경
     * @param memberDTO
     * @param model
     * @return 메세지 페이지 (msgBox.jsp)
     */
    @PostMapping("/passChangePro")
    public String passChangePro(MemberDTO memberDTO, Model model){
        memberService.memberPassChange(memberDTO);
        model.addAttribute("msg", Message.MEMBER_PASS_CHANGE_SUCCESS);
        model.addAttribute("url", RedirectUrl.MAIN);
        return "msgBox";
    }

    /**
     * 내정보 페이지 매핑
     * @param model
     * @return 내정보 페이지
     */
    @GetMapping("/memberInfo")
    public String memberInfo(Model model){
        return "member/info";
    }


}
