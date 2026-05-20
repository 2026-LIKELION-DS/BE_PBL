package org.example.week_7.domain.member.repository;

import org.example.week_7.domain.member.model.Member;
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
    public Member findByName(String name) {
        for (Member member : members) {
            if (member.getName().equals(name)) {
                return member;
            }
        }
        return null;
    }

    @Override
    public List<Member> findAll() {
        return members;
    }

    @Override
    public void delete(String name) {
        members.removeIf(member -> member.getName().equals(name));
    }
}