package com.likelion.pbl.repository;

import com.likelion.pbl.domain.role.Role;
import java.util.Optional;

public interface MemberRepository {
    void save(Role member);
    Optional<Role> findByName(String memberName);
    void updateByName(String name, Role member);
    boolean deleteByName(String name);
    boolean existsByName(String name);
}