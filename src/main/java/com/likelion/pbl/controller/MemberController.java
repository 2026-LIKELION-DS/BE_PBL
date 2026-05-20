package com.likelion.pbl.controller;

import com.likelion.pbl.domain.role.Lion;
import com.likelion.pbl.domain.role.Role;
import com.likelion.pbl.domain.role.Staff;
import com.likelion.pbl.dto.*;
import com.likelion.pbl.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/lions")
    public ResponseEntity<LionResponse> enrollLion(@RequestBody LionCreateRequest request) {
        Lion createdLion = memberService.createLion(request);
        if (createdLion == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(LionResponse.from(createdLion));
    }

    @PostMapping("/staffs")
    public ResponseEntity<StaffResponse> enrollStaff(@RequestBody StaffCreateRequest request) {
        Staff createdStaff = memberService.createStaff(request);
        if (createdStaff == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(StaffResponse.from(createdStaff));
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> getMember(@PathVariable String name) {
        Optional<Role> memberOpt = memberService.findMemberByName(name);
        if (memberOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        Role member = memberOpt.get();
        if (member instanceof Lion) {
            return ResponseEntity.ok(LionResponse.from((Lion) member));
        } else if (member instanceof Staff) {
            return ResponseEntity.ok(StaffResponse.from((Staff) member));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping("/lions/{name}")
    public ResponseEntity<LionResponse> modifyLion(@PathVariable String name, @RequestBody LionUpdateRequest request) {
        Lion updatedLion = memberService.updateLion(name, request);
        if (updatedLion == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(LionResponse.from(updatedLion));
    }

    @PutMapping("/staffs/{name}")
    public ResponseEntity<StaffResponse> modifyStaff(@PathVariable String name, @RequestBody StaffUpdateRequest request) {
        Staff updatedStaff = memberService.updateStaff(name, request);
        if (updatedStaff == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(StaffResponse.from(updatedStaff));
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<Void> removeMember(@PathVariable String name) {
        boolean isDeleted = memberService.deleteMember(name);
        if (!isDeleted) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.noContent().build();
    }
}