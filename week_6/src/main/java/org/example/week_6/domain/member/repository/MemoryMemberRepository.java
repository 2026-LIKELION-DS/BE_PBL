package org.example.week_6.domain.member.repository;

import org.example.week_6.domain.member.model.Member;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MemoryMemberRepository implements MemberRepository {

    private final List<Member> members = new ArrayList<>();

    @Override
    public void save(Member member) {
        members.add(member);
    }

    @Override
    public List<Member> findAll() {
        return members;
    }

    @Override
    public Member findByName(String name) {
        for (Member member : members) {
            if (member.getName().equals(name)) {
                return member;
            }
        }

        return null;
    }
}