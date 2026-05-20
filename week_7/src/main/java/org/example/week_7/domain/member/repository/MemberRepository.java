package org.example.week_7.domain.member.repository;

import org.example.week_7.domain.member.model.Member;

import java.util.List;

public interface MemberRepository {

    void save(Member member);

    default Member findByName() {
        return findByName(null);
    }

    Member findByName(String name);

    List<Member> findAll();

    void delete(String name);
}