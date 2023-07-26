package sap.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sap.domain.Member;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class MemoryMemberRepositoryTest {
    @Autowired
    MemoryMemberRepository repository;

    @AfterEach
    void afterEach() {
        repository.clearStore();
    }

    @Test
    void save() {
        Member member = new Member();
        member.setUser_id("user1");
        member.setName("홍길동");
        // "hello"라는 문자열의 sha-256 해시 값
        member.setPassword("2cf24dba5fb0a30e26e83b2ac5b9e29e1b161e5c1fa7425e73043362938b9824");
        member.setPhone_number("0101231234");
        member.setAddress("서울특별시 강남구 강남대로 123-45");
        member.setEmail("user1@gmail.com");

        repository.save(member);

        Member result = repository.findById(member.getMember_id()).get();
        assertThat(member).isEqualTo(result);

    }

    @Test
    void findById() {
        Member member1 = new Member();
        member1.setUser_id("user1");
        member1.setName("홍길동");
        // "hello"라는 문자열의 sha-256 해시 값
        member1.setPassword("2cf24dba5fb0a30e26e83b2ac5b9e29e1b161e5c1fa7425e73043362938b9824");
        member1.setPhone_number("0101231234");
        member1.setAddress("서울특별시 강남구 강남대로 123-45");
        member1.setEmail("user1@gmail.com");
        repository.save(member1);

        Member result = repository.findById(member1.getMember_id()).get();
        assertThat(result.getName()).isEqualTo(member1.getName());
    }

    @Test
    void findByName() {
        Member member1 = new Member();
        member1.setUser_id("user1");
        member1.setName("홍길동");
        // "hello"라는 문자열의 sha-256 해시 값
        member1.setPassword("2cf24dba5fb0a30e26e83b2ac5b9e29e1b161e5c1fa7425e73043362938b9824");
        member1.setPhone_number("0101231234");
        member1.setAddress("서울특별시 강남구 강남대로 123-45");
        member1.setEmail("user1@gmail.com");
        repository.save(member1);

        Member member2 = new Member();
        member2.setUser_id("user2");
        member2.setName("고길동");
        // "hello"라는 문자열의 sha-256 해시 값
        member2.setPassword("2cf24dba5fb0a30e26e83b2ac5b9e29e1b161e5c1fa7425e73043362938b9824");
        member2.setPhone_number("0101231235");
        member2.setAddress("서울특별시 강남구 강남대로 123-46");
        member2.setEmail("user2@gmail.com");
        repository.save(member2);

        Member result = repository.findByName("홍길동").get();
        assertThat(result).isEqualTo(member1);
    }
    @Test
    void findAll() {
        Member member1 = new Member();
        member1.setUser_id("user1");
        member1.setName("홍길동");
        // "hello"라는 문자열의 sha-256 해시 값
        member1.setPassword("2cf24dba5fb0a30e26e83b2ac5b9e29e1b161e5c1fa7425e73043362938b9824");
        member1.setPhone_number("0101231234");
        member1.setAddress("서울특별시 강남구 강남대로 123-45");
        member1.setEmail("user1@gmail.com");
        repository.save(member1);

        Member member2 = new Member();
        member2.setUser_id("user2");
        member2.setName("고길동");
        // "hello"라는 문자열의 sha-256 해시 값
        member2.setPassword("2cf24dba5fb0a30e26e83b2ac5b9e29e1b161e5c1fa7425e73043362938b9824");
        member2.setPhone_number("0101231235");
        member2.setAddress("서울특별시 강남구 강남대로 123-46");
        member2.setEmail("user2@gmail.com");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }
}
