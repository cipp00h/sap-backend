package com.sap.repository;

import com.sap.domain.Member;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;



    @Override

    public Member save(Member member) {
        member.setMember_id(++sequence);
        store.put(member.getMember_id(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long member_id) {
        return Optional.ofNullable(store.get(member_id));
    }

    @Override
    public Optional<Member> findByUserId(String user_id) {
        return findAll().stream()
                .filter(m -> m.getUser_id().equals(user_id))
                .findFirst();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
