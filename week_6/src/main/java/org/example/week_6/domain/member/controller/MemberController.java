package org.example.week_6.domain.member.controller;

import org.example.week_6.domain.member.model.Member;
import org.example.week_6.domain.member.service.MemberService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemberController {

    private final MemberService memberService;

    // 생성자가 1개라서 @Autowired 생략 가능
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello, Likelion!";
    }

    @PostMapping("/members")
    public String register() {
        return register(null);
    }

    @PostMapping("/members")
    public String register(@RequestBody Member member) {
        return memberService.register(member);
    }

    @GetMapping("/members")
    public List<Member> getAllMembers() {
        return memberService.getAllMembers();
    }

    @GetMapping("/members/search")
    public Member searchMember(@RequestParam String name) {
        return memberService.searchMember(name);
    }
}