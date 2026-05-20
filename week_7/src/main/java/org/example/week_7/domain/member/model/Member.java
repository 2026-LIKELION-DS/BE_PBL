package org.example.week_7.domain.member.model;

public abstract class Member {

    protected String name;
    protected String major;

    public Member(String name, String major) {
        this.name = name;
        this.major = major;
    }

    public String getName() {
        return name;
    }

    public String getMajor() {
        return major;
    }
}
