package net.likelion.backend.policy;

import net.likelion.backend.role.Role;

public interface SubmissionPolicy {
    boolean checkSubmission(Role role, boolean isLate);
}
