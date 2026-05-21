package net.likelion.backend.role;

public class Staff extends Role {
    private String position;

    public Staff(String name, String major, int generation, String part, String position) {
        super(name, major, generation, part);
        this.position = position;
    }

    public String getPosition() { return position; }

    public void updateStaffInfo(String major, int generation, String part, String position) {
        super.updateInfo(major, generation, part);
        this.position = position;
    }

    @Override
    public String getRoleName() { return "운영진"; }
}