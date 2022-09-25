package com.shopUpdate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class MyPageController {

    @GetMapping("/mypage")
    public String mypage(HttpSession session){
        if(session == null){
            return "main";
        }else{
            return "mypage/mypage";
        }

    }

}
