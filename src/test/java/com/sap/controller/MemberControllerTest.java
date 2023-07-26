package com.sap.controller;

import com.sap.domain.Member;
import com.sap.service.MemberService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MemberController.class)
public class MemberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MemberService memberService;

    private Member testMember;

    @BeforeEach
    public void setUp() {
        testMember = new Member(1L, "test_user", "Test User", "test_password", "010-1234-5678", "test@example.com", "Test Address", true);
    }

    @Test
    public void Join() throws Exception {
        // 회원 가입 정보를 전달하는 POST 요청을 시뮬레이션
        ResultActions resultActions = mockMvc.perform(post("/join")
                .param("user_id", testMember.getUser_id())
                .param("name", testMember.getName())
                .param("password", testMember.getPassword())
                .param("phone_number", testMember.getPhone_number())
                .param("email", testMember.getEmail())
                .param("address", testMember.getAddress())
                .param("agreed_to_policy", String.valueOf(testMember.isAgreed_to_policy()))
        );

        // HTTP 상태 코드가 200(OK)인지 확인
        resultActions.andExpect(status().isOk());

        // MemberService의 join 메서드가 호출되었는지 확인
        verify(memberService).join(any(Member.class));
    }
}
