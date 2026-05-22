package net.likelion.backend.config;

import net.likelion.backend.member.MemberRepository;
import net.likelion.backend.member.MemberService;
import net.likelion.backend.member.MemoryMemberRepository;
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