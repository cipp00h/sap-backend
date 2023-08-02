package sap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sap.domain.Member;
import sap.service.MemberService;

@Controller
@CrossOrigin
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // 회원 가입 API
    @PostMapping("members/join")
    @ResponseBody
    public ResponseEntity<Long> join(@RequestBody Member member) {
        Long memberId = memberService.join(member);
        return new ResponseEntity<>(memberId, HttpStatus.CREATED);

    }

}