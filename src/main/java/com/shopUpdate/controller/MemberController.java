package com.shopUpdate.controller;

import com.shopUpdate.common.enums.Message;
import com.shopUpdate.common.enums.RedirectUrl;
import com.shopUpdate.domain.MemberDTO;
import com.shopUpdate.exception.BaseException;
import com.shopUpdate.exception.ErrorCode;
import com.shopUpdate.service.MemberService;
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
        model.addAttribute("msg", Message.MEMBER_JOIN.getMessage());
        model.addAttribute("url", RedirectUrl.MAIN.getUrl());
        return "msgBox";
    }

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

    //로그인 페이지
    @GetMapping("/login")
    public String login(){
        return "/member/login";
    }


    //로그인
    @PostMapping("/loginPro")
    public String loginPro(MemberDTO memberDTO, Model model, HttpSession session) throws Exception {

        memberDTO = memberService.loginPro(memberDTO);
        if(memberDTO == null) throw new BaseException(ErrorCode.MEMBER_LOGIN_FAIL, "/login");
//        if(memberDTO == null) {
//            System.out.println("로그인 실패");
//            model.addAttribute("msg" , "로그인 실패!");
//            model.addAttribute("url", "/login");
//            return "msgBox";
//        }else{
//            session.setAttribute("userInfo", memberDTO);
//            System.out.println(memberDTO.getMemNm());
//            model.addAttribute("msg" , "로그인 성공!");
//            model.addAttribute("url", "/main");
//            return "msgBox";
//        }
        session.setAttribute("userInfo", memberDTO);
        System.out.println(memberDTO.getMemNm());
        model.addAttribute("msg" , "로그인 성공!");
        model.addAttribute("url", "/main");
        return "msgBox";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session, Model model){
        session.invalidate();
        model.addAttribute("url", "/main");
        model.addAttribute("msg", "로그아웃 되었습니다.");
        return "msgBox";
    }

    @PostMapping("/emailCheck")
    @ResponseBody
    public String emailCheck(String email){
        System.out.println("MailContoller::emailCheck");
        String result = "false";
        if(memberService.userEmailCheck(email) == null){
            result = "true";
        }
        return result;
    }

    @GetMapping("/member/test")
    public String test(){
        return "member/test";
    }


    @GetMapping("/findId")
    public String findId(){
        return "member/findId";
    }

    @PostMapping("/findIdOk")
    public String findIdOk(MemberDTO memberDTO, Model model){
        String memId = memberService.findId(memberDTO);
        model.addAttribute("memId",  memId);
        return "member/findIdOk";
    }

    @GetMapping("/withdrawal")
    public String withdrawal(){
        return "member/memberDelete";
    }

    @PostMapping("/withdrawalPro")
    public String withdrawal(MemberDTO memberDTO){
        System.out.println("MemberController::withdrawal");
        memberService.deleteMember(memberDTO);
        return "member/test";
    }


    @GetMapping("/passChange")
    public String passChange(){
        return "member/findPass";
    }

    @PostMapping("/passChangePro")
    public String passChangePro(MemberDTO memberDTO, Model model){
        System.out.println("MemberController::passChange");
        memberService.memberPassChange(memberDTO);
        model.addAttribute("msg", "비밀번호가 변경되었습니다.");
        model.addAttribute("url", "/mypage/mypage");
        return "msgBox";
    }

    @GetMapping("/memberInfo")
    public String memberInfo(Model model){
        return "member/info";
    }

    @GetMapping
    public String memberCart(){
        return "member/cart";
    }

}
