package com.sap.repository;

import com.sap.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

public class MemoryMemberRepositoryTest {
    private MemberRepository memberRepository;

    @BeforeEach
    public void setUp() {
        // 각 테스트마다 새로운 MemoryMemberRepository 인스턴스를 생성합니다.
        memberRepository = new MemoryMemberRepository();
    }

    @AfterEach
    public void tearDown() {
        // 각 테스트 이후에는 메모리 상의 저장소를 초기화하여 깨끗한 상태로 유지합니다.
        ((MemoryMemberRepository) memberRepository).clearStore();
    }

    @Test
    public void testSave() {
        // 주어진 정보로 Member 객체를 생성합니다.
        Member member = new Member();
        member.setUser_id("spring1");
        member.setName("Haeun");
        member.setPassword("password123");
        member.setPhone_number("1234567890");
        member.setEmail("abc@abc.com");
        member.setAddress("서울시 강남구 테헤란로,123");
        member.setAgreed_to_policy(true);

        // Member 객체를 저장합니다.
        Member savedMember = memberRepository.save(member);

        // 저장된 Member 객체의 member_id가 null이 아닌지 검증합니다.
        assertNotNull(savedMember.getMember_id());
        // 주어진 정보로 생성한 Member 객체와 저장된 Member 객체의 정보가 동일한지 검증합니다.
        assertEquals(member.getUser_id(), savedMember.getUser_id());
        assertEquals(member.getName(), savedMember.getName());
        // 다른 Member 속성에 대한 추가 검증을 수행할 수 있습니다.
    }

    @Test
    public void testFindById() {
        // 주어진 정보로 Member 객체를 생성하고 저장합니다.
        Member member = new Member();
        member.setUser_id("spring2");
        member.setName("Sara");
        member.setPassword("password456");
        member.setPhone_number("9876543210");
        member.setEmail("bbb@bbb.com");
        member.setAddress("경기도 성남시 중원구 121");
        member.setAgreed_to_policy(true);
        Member savedMember = memberRepository.save(member);

        // member_id를 사용하여 Member 객체를 조회합니다.
        Optional<Member> foundMember = memberRepository.findById(savedMember.getMember_id());

        // 조회된 Member 객체가 존재하는지 확인합니다.
        assertTrue(foundMember.isPresent());
        // 주어진 정보로 생성한 Member 객체와 조회된 Member 객체의 정보가 동일한지 검증합니다.
        assertEquals(savedMember.getMember_id(), foundMember.get().getMember_id());
        assertEquals(savedMember.getUser_id(), foundMember.get().getUser_id());
        assertEquals(savedMember.getName(), foundMember.get().getName());
        // 다른 Member 속성에 대한 추가 검증을 수행할 수 있습니다.
    }

    @Test
    public void testFindByUserId() {
        // 주어진 정보로 Member 객체를 생성하고 저장합니다.
        Member member = new Member();
        member.setUser_id("spring2");
        member.setName("Sara");
        member.setPassword("password456");
        member.setPhone_number("9876543210");
        member.setEmail("bbb@bbb.com");
        member.setAddress("경기도 성남시 중원구 121");
        member.setAgreed_to_policy(true);
        Member savedMember = memberRepository.save(member);

        // user_id를 사용하여 Member 객체를 조회합니다.
        Optional<Member> foundMember = memberRepository.findByUserId("spring2");

        // 조회된 Member 객체가 존재하는지 확인합니다.
        assertTrue(foundMember.isPresent());
        // 주어진 정보로 생성한 Member 객체와 조회된 Member 객체의 정보가 동일한지 검증합니다.
        assertEquals(member.getUser_id(), foundMember.get().getUser_id());
        assertEquals(member.getName(), foundMember.get().getName());
        // 다른 Member 속성에 대한 추가 검증을 수행할 수 있습니다.
    }

    @Test
    public void testFindAll() {
        // 주어진 정보로 Member 객체 두 개를 생성하고 저장합니다.
        Member member1 = new Member();
        member1.setUser_id("spring2");
        member1.setName("Sara");
        member1.setPassword("password456");
        member1.setPhone_number("9876543210");
        member1.setEmail("bbb@bbb.com");
        member1.setAddress("경기도 성남시 중원구 121");
        member1.setAgreed_to_policy(true);
        Member savedMember = memberRepository.save(member1);

        Member member2 = new Member();
        member2.setUser_id("Spring3");
        member2.setName("Mina");
        member2.setPassword("password789");
        member2.setPhone_number("9876543210");
        member2.setEmail("ccc@ccc.com");
        member2.setAddress("강원도 속초시 125");
        member2.setAgreed_to_policy(true);
        memberRepository.save(member2);

        // 모든 Member 객체를 조회합니다.
        List<Member> allMembers = memberRepository.findAll();

        // 저장된 Member 객체들의 개수가 2개인지 확인합니다.
        assertEquals(2, allMembers.size());
        // 다른 Member 속성에 대한 추가 검증을 수행할 수 있습니다.
    }
}
