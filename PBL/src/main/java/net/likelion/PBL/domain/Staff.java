package net.likelion.PBL.domain;

public class Staff extends Member {
    private String position;

    public Staff(String name, String major, int generation, String part, String position) {
        super(name, major, generation, part, "STAFF");
        this.position = position;
    }

    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }
}