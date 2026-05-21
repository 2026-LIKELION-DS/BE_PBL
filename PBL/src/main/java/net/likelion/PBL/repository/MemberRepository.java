package net.likelion.PBL.repository;

import net.likelion.PBL.domain.Member;

public interface MemberRepository {
    void save(Member member);
    Member findByName(String name);

    void updateByName(String name, Member member);
    boolean deleteByName(String name);
    boolean existsByName(String name);
}
