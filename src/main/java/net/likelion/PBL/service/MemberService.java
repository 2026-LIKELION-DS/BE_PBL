package net.likelion.PBL.service;

import net.likelion.PBL.domain.Lion;
import net.likelion.PBL.domain.Staff;
import net.likelion.PBL.domain.Role;
import net.likelion.PBL.dto.*;
import net.likelion.PBL.role.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService {

    private final List<Role> members = new ArrayList<>();

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Role findByName(String name) {
        for (Role member : members) {
            if (member.getName().equals(name)) {
                return member;
            }
        }
        return null;
    }

    public LionResponse createLion(LionCreateRequest request) {
        if (findByName(request.getName()) != null) {
            return null;
        }
        Lion lion = new Lion(
                request.getName(),
                request.getMajor(),
                request.getGeneration(),
                request.getPart(),
                request.getStudentId()
        );
        members.add(lion);
        return LionResponse.from(lion);
    }

    public StaffResponse createStaff(StaffCreateRequest request) {
        if (findByName(request.getName()) != null) {
            return null;
        }
        Staff staff = new Staff(
                request.getName(),
                request.getMajor(),
                request.getGeneration(),
                request.getPart(),
                request.getPosition()
        );
        members.add(staff);
        return StaffResponse.from(staff);
    }

    public LionResponse updateLion(String name, LionUpdateRequest request) {
        for (Role member : members) {
            if (member instanceof Lion lion && lion.getName().equals(name)) {
                return LionResponse.from(lion);
            }
        }
        return null;
    }

    public StaffResponse updateStaff(String name, StaffUpdateRequest request) {
        for (Role member : members) {
            if (member instanceof Staff staff && staff.getName().equals(name)) {
                return StaffResponse.from(staff);
            }
        }
        return null;
    }

    public boolean deleteMember(String name) {
        return members.removeIf(member -> member.getName().equals(name));
    }
}