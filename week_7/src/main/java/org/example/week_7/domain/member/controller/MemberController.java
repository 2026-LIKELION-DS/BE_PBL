package org.example.week_7.domain.member.controller;

import org.example.week_7.domain.member.dto.LionRequestDto;
import org.example.week_7.domain.member.dto.StaffRequestDto;
import org.example.week_7.domain.member.model.Member;
import org.example.week_7.domain.member.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // Lion 등록
    @PostMapping("/lions")
    public ResponseEntity<String> createLion(
            @RequestBody LionRequestDto dto
    ) {

        memberService.createLion(dto);

        return ResponseEntity.ok("Lion 등록 완료");
    }

    @PostMapping("/staffs")
    public ResponseEntity<String> createStaff(
            @RequestBody StaffRequestDto dto
    ) {

        memberService.createStaff(dto);

        return ResponseEntity.ok("Staff 등록 완료");
    }

    @GetMapping("/{name}")
    public ResponseEntity<Member> findMember(
            @PathVariable String name
    ) {

        Member member = memberService.findMember(name);

        return ResponseEntity.ok(member);
    }

    @PutMapping("/lions/{name}")
    public ResponseEntity<String> updateLion(
            @PathVariable String name,
            @RequestBody LionRequestDto dto
    ) {

        memberService.updateLion(name, dto);

        return ResponseEntity.ok("Lion 수정 완료");
    }

    @PutMapping("/staffs/{name}")
    public ResponseEntity<String> updateStaff(
            @PathVariable String name,
            @RequestBody StaffRequestDto dto
    ) {

        memberService.updateStaff(name, dto);

        return ResponseEntity.ok("Staff 수정 완료");
    }

    // 삭제
    @DeleteMapping("/{name}")
    public ResponseEntity<String> deleteMember(
            @PathVariable String name
    ) {

        memberService.deleteMember(name);

        return ResponseEntity.ok("멤버 삭제 완료");
    }
}