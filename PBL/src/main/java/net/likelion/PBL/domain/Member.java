package net.likelion.PBL.domain;

public class Member {
    private String name;
    private String major;
    private int generation;
    private String part;
    private String roleName;

    public Member(String name, String major, int generation, String part, String roleName) {
        this.name = name;
        this.major = major;
        this.generation = generation;
        this.part = part;
        this.roleName = roleName;
    }

    public String getName() { return name; }
    public String getMajor() { return major; }
    public void setMajor(String major) { this.major = major; }
    public int getGeneration() { return generation; }
    public void setGeneration(int generation) { this.generation = generation; }
    public String getPart() { return part; }
    public void setPart(String part) { this.part = part; }
    public String getRoleName() { return roleName; }
}