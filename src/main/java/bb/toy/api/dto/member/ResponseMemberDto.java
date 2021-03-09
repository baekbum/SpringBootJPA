package bb.toy.api.dto.member;

import bb.toy.api.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class ResponseMemberDto {

    private String id;
    private String name;
    private String tel;
    private String gradeId;
    private String gradeName;
    private int discount;

    public ResponseMemberDto (Member member) {
        setId(member.getId());
        setName(member.getName());
        setTel(member.getTel());
        setGradeId(member.getGrade().getId());
        setGradeName(member.getGrade().getName());
        setDiscount(member.getGrade().getDiscount());
    }
}
