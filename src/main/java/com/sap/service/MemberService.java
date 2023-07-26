package com.sap.service;

import com.sap.domain.Member;

import java.util.Optional;

public interface MemberService {
    void join(Member member);

    Optional<Member> findMember(Long member_id);
}
