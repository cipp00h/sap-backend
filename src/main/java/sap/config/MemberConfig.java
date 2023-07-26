package sap.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sap.repository.MemberRepository;
import sap.repository.MemoryMemberRepository;
import sap.service.MemberService;
import sap.service.MemberServiceImpl;

@Configuration
public class MemberConfig {
    // 생성자 주입
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

}
