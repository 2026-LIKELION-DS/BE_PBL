package net.likelion.PBL.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.likelion.PBL.domain.Lion;

@Getter
@AllArgsConstructor
public class LionResponse {

    private String name;
    private String major;
    private int generation;
    private String part;
    private String roleName;
    private String studentId;

    public static LionResponse from(Lion lion) {
        return new LionResponse(
                lion.getName(),
                lion.getMajor(),
                lion.getGeneration(),
                lion.getPart(),
                lion.roleName(),
                lion.getStudentId()
        );
    }
}
