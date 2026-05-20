package org.example.week_7.domain.member.service;

import org.example.week_7.domain.member.dto.LionRequestDto;
import org.example.week_7.domain.member.dto.StaffRequestDto;
import org.example.week_7.domain.member.model.Lion;
import org.example.week_7.domain.member.model.Member;
import org.example.week_7.domain.member.model.Staff;
import org.example.week_7.domain.member.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void createLion(LionRequestDto dto) {

        Lion lion = new Lion(
                dto.getName(),
                dto.getMajor(),
                dto.getStudentId()
        );

        memberRepository.save(lion);
    }

    public void createStaff(StaffRequestDto dto) {

        Staff staff = new Staff(
                dto.getName(),
                dto.getMajor(),
                dto.getPosition()
        );

        memberRepository.save(staff);
    }

    public Member findMember(String name) {
        return memberRepository.findByName(name);
    }

    public void deleteMember(String name) {
        memberRepository.delete(name);
    }

    public void updateLion(String name, LionRequestDto dto) {

        Lion lion = (Lion) memberRepository.findByName(name);

        lion.update(
                dto.getMajor(),
                dto.getStudentId()
        );
    }

    public void updateStaff(String name, StaffRequestDto dto) {

        Staff staff = (Staff) memberRepository.findByName(name);

        staff.update(
                dto.getMajor(),
                dto.getPosition()
        );
    }
}