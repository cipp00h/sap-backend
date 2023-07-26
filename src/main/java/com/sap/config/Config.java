package com.sap.config;

import com.sap.service.MemberService;
import com.sap.service.MemberServiceImpl;
import com.sap.repository.MemberRepository;
import com.sap.repository.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(MemberRepository());
    }

    @Bean
    private static MemberRepository MemberRepository() {
        return new MemoryMemberRepository();
    }


}
