package com.likelion.pbl.config;

import com.likelion.pbl.repository.MemberRepository;
import com.likelion.pbl.repository.MemoryMemberRepository;
import com.likelion.pbl.service.MemberService;
import org.springframework.context.annotation.Bean;

public class AppConfig {

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }
}
