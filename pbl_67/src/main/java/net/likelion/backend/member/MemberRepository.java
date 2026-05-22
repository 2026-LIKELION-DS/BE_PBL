package net.likelion.backend.member;

import net.likelion.backend.role.Role;

public interface MemberRepository {
    void save(Role role);
    Role findByName(String name);
    void updateByName(String name, Role member);
    boolean deleteByName(String name);
    boolean existsByName(String name);
}
