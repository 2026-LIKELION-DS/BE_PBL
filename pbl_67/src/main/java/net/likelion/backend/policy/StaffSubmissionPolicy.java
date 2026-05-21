package net.likelion.backend.policy;

import net.likelion.backend.role.Role;

public class StaffSubmissionPolicy implements SubmissionPolicy {
    @Override
    public boolean checkSubmission(Role role, boolean isLate) {
        // 운영진은 지각 여부와 관계없이 항상 제출 가능 상태로 처리하는 정책 예시
        return true;
    }
}
