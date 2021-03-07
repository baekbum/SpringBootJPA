package bb.toy.api.dto.member;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseMemberDto {

    private String id;
    private String name;
    private String tel;
    private String gradeId;
    private String gradeName;
    private int discount;

}
