package net.likelion.PBL.controller;

import lombok.RequiredArgsConstructor;
import net.likelion.PBL.domain.Lion;
import net.likelion.PBL.domain.Role;
import net.likelion.PBL.domain.Staff;
import net.likelion.PBL.domain.Role;
import net.likelion.PBL.dto.*;
import net.likelion.PBL.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/lions")
    public ResponseEntity<LionResponse> createLion(@RequestBody LionCreateRequest request) {
        LionResponse response = memberService.createLion(request);
        if (response == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build(); // 409
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(response); // 201
    }

    @PostMapping("/staffs")
    public ResponseEntity<StaffResponse> createStaff(@RequestBody StaffCreateRequest request) {
        StaffResponse response = memberService.createStaff(request);
        if (response == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build(); // 409
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(response); // 201
    }

    @GetMapping("/{name}")
    public ResponseEntity<Object> getMember(@PathVariable String name) {
        Role member = memberService.findByName(name);
        if (member == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // 404
        }
        if (member instanceof Lion) return ResponseEntity.ok(LionResponse.from((Lion) member));
        if (member instanceof Staff) return ResponseEntity.ok(StaffResponse.from((Staff) member));
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @PutMapping("/lions/{name}")
    public ResponseEntity<LionResponse> updateLion(@PathVariable String name, @RequestBody LionUpdateRequest request) {
        LionResponse response = memberService.updateLion(name, request);
        if (response == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // 404
        }
        return ResponseEntity.ok(response); // 200
    }

    @PutMapping("/staffs/{name}")
    public ResponseEntity<StaffResponse> updateStaff(@PathVariable String name, @RequestBody StaffUpdateRequest request) {
        StaffResponse response = memberService.updateStaff(name, request);
        if (response == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // 404
        }
        return ResponseEntity.ok(response); // 200
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<Void> deleteMember(@PathVariable String name) {
        boolean result = memberService.deleteMember(name);
        if (!result) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // 404
        }
        return ResponseEntity.noContent().build(); // 204
    }
}
