package net.likelion.PBL.config;

import net.likelion.PBL.repository.MemoryMemberRepository;
import net.likelion.PBL.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration

public class AppConfig {
    @Bean
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }
}
