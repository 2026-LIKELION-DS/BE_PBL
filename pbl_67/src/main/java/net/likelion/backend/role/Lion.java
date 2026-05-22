package net.likelion.backend.role;

public class Lion extends Role {
    private String studentId;

    public Lion(String name, String major, int generation, String part, String studentId) {
        super(name, major, generation, part);
        this.studentId = studentId;
    }

    public String getStudentId() { return studentId; }

    public void updateLionInfo(String major, int generation, String part, String studentId) {
        super.updateInfo(major, generation, part);
        this.studentId = studentId;
    }

    @Override
    public String getRoleName() { return "아기사자"; }
}