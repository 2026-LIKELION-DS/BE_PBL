package net.likelion.PBL.repository;

import org.springframework.stereotype.Repository;

@Repository
public class MemoryMemberRepository {
    public String test() {
        return "저장소 연결 성공";
    }
}
