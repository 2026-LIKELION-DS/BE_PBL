package org.example.week_7.domain.member.model;

public class Staff extends Member {

    private String position;

    public Staff(String name, String major, String position) {
        super(name, major);
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void update(String major, String position) {
        this.major = major;
        this.position = position;
    }
}
