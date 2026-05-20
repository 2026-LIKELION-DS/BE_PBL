package org.example.week_6.domain.member.service;

import org.example.week_6.domain.member.model.Member;
import org.example.week_6.domain.member.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    // 생성자가 1개라서 @Autowired 생략 가능
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public String register(Member member) {
        Member foundMember = memberRepository.findByName(member.getName());

        if (foundMember != null) {
            return "이미 등록된 이름입니다.";
        }

        memberRepository.save(member);
        return "등록 완료: " + member.getName();
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Member searchMember(String name) {
        return memberRepository.findByName(name);
    }
}