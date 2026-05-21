package net.likelion.backend.controller;

import net.likelion.backend.dto.*;
import net.likelion.backend.member.MemberService;
import net.likelion.backend.role.Lion;
import net.likelion.backend.role.Role;
import net.likelion.backend.role.Staff;
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
    public ResponseEntity<?> createLion(@RequestBody LionCreateRequest request) {
        Role role = memberService.createLion(request);
        if (role == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(LionResponse.from((Lion) role));
    }

    @PostMapping("/staffs")
    public ResponseEntity<?> createStaff(@RequestBody StaffCreateRequest request) {
        Role role = memberService.createStaff(request);
        if (role == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(StaffResponse.from((Staff) role));
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> getMember(@PathVariable String name) {
        Role role = memberService.findMember(name);
        if (role == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        if (role instanceof Lion) {
            return ResponseEntity.ok(LionResponse.from((Lion) role));
        } else {
            return ResponseEntity.ok(StaffResponse.from((Staff) role));
        }
    }

    @PutMapping("/lions/{name}")
    public ResponseEntity<?> updateLion(@PathVariable String name, @RequestBody LionUpdateRequest request) {
        Role role = memberService.updateLion(name, request);
        if (role == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(LionResponse.from((Lion) role));
    }

    @PutMapping("/staffs/{name}")
    public ResponseEntity<?> updateStaff(@PathVariable String name, @RequestBody StaffUpdateRequest request) {
        Role role = memberService.updateStaff(name, request);
        if (role == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(StaffResponse.from((Staff) role));
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<Void> deleteMember(@PathVariable String name) {
        boolean deleted = memberService.deleteMember(name);
        if (!deleted) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
