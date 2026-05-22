package net.likelion.backend.policy;

import net.likelion.backend.role.Role;

public class LionSubmissionPolicy implements SubmissionPolicy {
    @Override
    public boolean checkSubmission(Role role, boolean isLate) {
        // 아기사자는 지각 제출 시 패널티가 있거나 통과하지 못하는 정책 예시
        return !isLate;
    }
}