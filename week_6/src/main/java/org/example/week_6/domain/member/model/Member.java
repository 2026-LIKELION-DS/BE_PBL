package org.example.week_6.domain.member.model;

public class Member {

    private String name;
    private String major;
    private int generation;
    private String part;
    private String studentId;
    private String role;

    public Member() {
    }

    public Member(String name, String major, int generation, String part, String studentId, String role) {
        this.name = name;
        this.major = major;
        this.generation = generation;
        this.part = part;
        this.studentId = studentId;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public String getMajor() {
        return major;
    }

    public int getGeneration() {
        return generation;
    }

    public String getPart() {
        return part;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getRole() {
        return role;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setGeneration(int generation) {
        this.generation = generation;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setRole(String role) {
        this.role = role;
    }
}