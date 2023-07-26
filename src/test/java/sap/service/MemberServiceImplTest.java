package sap.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sap.domain.Member;
import sap.repository.MemberRepository;
import sap.repository.MemoryMemberRepository;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class MemberServiceImplTest {
    @Autowired
    MemberServiceImpl memberService;

    @Test
    void join() {
        Member member = new Member();
        member.setUser_id("user1");
        member.setName("홍길동");
        // "hello"라는 문자열의 sha-256 해시 값
        member.setPassword("2cf24dba5fb0a30e26e83b2ac5b9e29e1b161e5c1fa7425e73043362938b9824");
        member.setPhone_number("0101231234");
        member.setAddress("서울특별시 강남구 강남대로 123-45");
        member.setEmail("user1@gmail.com");

        Long saveId = memberService.join(member);

        Member findMember = memberService.findMember(saveId).get();
        assertThat(findMember.getName()).isEqualTo(member.getName());
    }

    @Test
    void findMember() {
        Member member = new Member();
        member.setUser_id("user1");
        member.setName("홍길동");
        // "hello"라는 문자열의 sha-256 해시 값
        member.setPassword("2cf24dba5fb0a30e26e83b2ac5b9e29e1b161e5c1fa7425e73043362938b9824");
        member.setPhone_number("0101231234");
        member.setAddress("서울특별시 강남구 강남대로 123-45");
        member.setEmail("user1@gmail.com");

        Long saveId = memberService.join(member);

        Member findMember = memberService.findMember(saveId).get();
        assertThat(findMember).isEqualTo(member);

    }
}