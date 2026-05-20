package net.likelion.PBL.service;

import net.likelion.PBL.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    private final MemoryMemberRepository memberRepository;

    @Autowired
    public MemberService(MemoryMemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public String getTestMessage() {
        return memberRepository.test() + " -> 서비스 계층 통과!";
    }
}
