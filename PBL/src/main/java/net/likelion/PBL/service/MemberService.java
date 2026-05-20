package net.likelion.PBL.service;

import net.likelion.PBL.domain.Lion;
import net.likelion.PBL.domain.Member;
import net.likelion.PBL.domain.Staff;
import net.likelion.PBL.DTO.*;
import net.likelion.PBL.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member createLion(LionCreateRequest request) {
        if (memberRepository.existsByName(request.getName())) {
            return null;
        }
        Lion lion = new Lion(request.getName(), request.getMajor(), request.getGeneration(), request.getPart(), request.getStudentId());
        memberRepository.save(lion);
        return lion;
    }

    public Member createStaff(StaffCreateRequest request) {
        if (memberRepository.existsByName(request.getName())) {
            return null;
        }
        Staff staff = new Staff(request.getName(), request.getMajor(), request.getGeneration(), request.getPart(), request.getPosition());
        memberRepository.save(staff);
        return staff;
    }

    public Member findMemberByName(String name) {
        return memberRepository.findByName(name);
    }

    public Member updateLion(String name, LionUpdateRequest request) {
        Member member = memberRepository.findByName(name);
        if (member == null || !(member instanceof Lion)) {
            return null;
        }

        Lion lion = (Lion) member;
        lion.setMajor(request.getMajor());
        lion.setGeneration(request.getGeneration());
        lion.setPart(request.getPart());
        lion.setStudentId(request.getStudentId());

        memberRepository.updateByName(name, lion);
        return lion;
    }


    public Member updateStaff(String name, StaffUpdateRequest request) {
        Member member = memberRepository.findByName(name);
        if (member == null || !(member instanceof Staff)) {
            return null;
        }

        Staff staff = (Staff) member;
        staff.setMajor(request.getMajor());
        staff.setGeneration(request.getGeneration());
        staff.setPart(request.getPart());
        staff.setPosition(request.getPosition());

        memberRepository.updateByName(name, staff);
        return staff;
    }
    
    public boolean deleteMember(String name) {
        return memberRepository.deleteByName(name);
    }
}