package org.example.week_7.domain.member.model;

public class Lion extends Member {

    private String studentId;

    public Lion(String name, String major, String studentId) {
        super(name, major);
        this.studentId = studentId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void update(String major, String studentId) {
        this.major = major;
        this.studentId = studentId;
    }
}
