package net.likelion.PBL.policy;

public class StaffSubmissionPolicy implements SubmissionPolicy {

    @Override
    public boolean canSubmit() {
        return false;
    }
}
