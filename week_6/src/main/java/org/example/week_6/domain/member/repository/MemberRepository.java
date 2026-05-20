package org.example.week_6.domain.member.repository;

import org.example.week_6.domain.member.model.Member;

import java.util.List;

public interface MemberRepository {

    void save(Member member);

    List<Member> findAll();

    Member findByName(String name);
}