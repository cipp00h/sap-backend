package com.sap.repository;

import com.sap.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);

    Optional<Member> findById(Long member_id);

    Optional<Member> findByUserId(String user_id);

    List<Member> findAll();

}
