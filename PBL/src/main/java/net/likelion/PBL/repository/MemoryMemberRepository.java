package net.likelion.PBL.repository;

import net.likelion.PBL.domain.Member;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MemoryMemberRepository implements MemberRepository { // 💡 인터페이스 연결 필수!

    private final List<Member> store = new ArrayList<>();

    public void save(Member member) {
        store.add(member);
    }

    public Member findByName(String name) {
        return store.stream()
                .filter(m -> m.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void updateByName(String name, Member updateMember) {
        for (int i = 0; i < store.size(); i++) {
            if (store.get(i).getName().equals(name)) {
                store.set(i, updateMember);
                return;
            }
        }
    }

    @Override
    public boolean deleteByName(String name) {
        return store.removeIf(member -> member.getName().equals(name));
    }

    @Override
    public boolean existsByName(String name) {
        return store.stream().anyMatch(member -> member.getName().equals(name));
    }
}