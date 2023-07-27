package com.sap.repository;

import com.sap.domain.Member;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;
@SpringBootTest

class MemoryMemberRepositoryTest {
    MemberRepository repository = new MemoryMemberRepository();

    @Test
    public void save() {
        Member member = new Member();
        member.setName("1234");
        member.setUser_id("spring");

        repository.save(member);
        Member result = repository.findById(member.getMember_id()).get();


        System.out.println("user_id : " + member.getUser_id());
        System.out.println("name : " + member.getName());
        System.out.println("result = " + result);

        assertThat(member).isEqualTo(result);

    }

}