package net.likelion.backend.member;

import net.likelion.backend.dto.LionCreateRequest;
import net.likelion.backend.dto.LionUpdateRequest;
import net.likelion.backend.dto.StaffCreateRequest;
import net.likelion.backend.dto.StaffUpdateRequest;
import net.likelion.backend.role.Lion;
import net.likelion.backend.role.Role;
import net.likelion.backend.role.Staff;
import org.springframework.stereotype.Service;


@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Role createLion(LionCreateRequest request) {
        if (memberRepository.existsByName(request.getName())) {
            return null;
        }
        Lion lion = new Lion(request.getName(), request.getMajor(), request.getGeneration(), request.getPart(), request.getStudentId());
        memberRepository.save(lion);
        return lion;
    }

    public Role createStaff(StaffCreateRequest request) {
        if (memberRepository.existsByName(request.getName())) {
            return null;
        }
        Staff staff = new Staff(request.getName(), request.getMajor(), request.getGeneration(), request.getPart(), request.getPosition());
        memberRepository.save(staff);
        return staff;
    }

    public Role findMember(String name) {
        return memberRepository.findByName(name);
    }

    public Role updateLion(String name, LionUpdateRequest request) {
        Role role = memberRepository.findByName(name);
        if (role instanceof Lion) {
            Lion lion = (Lion) role;
            lion.updateLionInfo(request.getMajor(), request.getGeneration(), request.getPart(), request.getStudentId());
            memberRepository.updateByName(name, lion);
            return lion;
        }
        return null;
    }

    public Role updateStaff(String name, StaffUpdateRequest request) {
        Role role = memberRepository.findByName(name);
        if (role instanceof Staff) {
            Staff staff = (Staff) role;
            staff.updateStaffInfo(request.getMajor(), request.getGeneration(), request.getPart(), request.getPosition());
            memberRepository.updateByName(name, staff);
            return staff;
        }
        return null;
    }

    public boolean deleteMember(String name) {
        return memberRepository.deleteByName(name);
    }
}