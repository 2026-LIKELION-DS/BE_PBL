package net.likelion.PBL.config;

import net.likelion.PBL.role.MemberRepository;
import net.likelion.PBL.role.MemoryMemberRepository;
import net.likelion.PBL.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
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