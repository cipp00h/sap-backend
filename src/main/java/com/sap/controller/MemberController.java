package com.sap.controller;

import com.sap.domain.Member;
import com.sap.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }


    @PostMapping("join")
    @ResponseBody
    public String join(@RequestParam("user_id") String user_id,
                       @RequestParam("name") String name,
                       @RequestParam("password") String password,
                       @RequestParam("phone_number") String phone_number,
                       @RequestParam("email") String email,
                       @RequestParam("address") String address,
                       @RequestParam("agreed_to_policy") boolean agreed_to_policy){

        Member member = new Member();
        member.setUser_id(user_id);
        member.setName(name);
        member.setPassword(password);
        member.setPhone_number(phone_number);
        member.setEmail(email);
        member.setAddress(address);
        member.setAgreed_to_policy(agreed_to_policy);

        memberService.join(member);

        return "회원가입 성공";
 }


}