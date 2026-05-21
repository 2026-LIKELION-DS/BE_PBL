package net.likelion.PBL.controller;

import net.likelion.PBL.domain.Lion;
import net.likelion.PBL.domain.Member;
import net.likelion.PBL.domain.Staff;
import net.likelion.PBL.DTO.*;
import net.likelion.PBL.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/lions")
    public ResponseEntity<Object> registerLion(@RequestBody LionCreateRequest request) {
        Member created = memberService.createLion(request);
        if (created == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(LionResponse.from((Lion) created));
    }

    @PostMapping("/staffs")
    public ResponseEntity<Object> registerStaff(@RequestBody StaffCreateRequest request) {
        Member created = memberService.createStaff(request);
        if (created == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(StaffResponse.from((Staff) created));
    }

    @GetMapping("/{name}")
    public ResponseEntity<Object> getMemberByName(@PathVariable String name) {
        Member member = memberService.findMemberByName(name);
        if (member == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        if (member instanceof Lion) {
            return ResponseEntity.ok(LionResponse.from((Lion) member));
        } else if (member instanceof Staff) {
            return ResponseEntity.ok(StaffResponse.from((Staff) member));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping("/lions/{name}")
    public ResponseEntity<Object> updateLion(@PathVariable String name, @RequestBody LionUpdateRequest request) {
        Member updated = memberService.updateLion(name, request);
        if (updated == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(LionResponse.from((Lion) updated));
    }
    
    @PutMapping("/staffs/{name}")
    public ResponseEntity<Object> updateStaff(@PathVariable String name, @RequestBody StaffUpdateRequest request) {
        Member updated = memberService.updateStaff(name, request);
        if (updated == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(StaffResponse.from((Staff) updated));
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<Void> deleteMember(@PathVariable String name) {
        boolean isDeleted = memberService.deleteMember(name);
        if (!isDeleted) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}