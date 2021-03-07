package bb.toy.api.domain.dto.member;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
public class RequestMemberDto {

    @NotEmpty
    private String id;

    @NotEmpty
    private String password;

    @NotEmpty
    private String name;

    @NotEmpty
    private String tel;

    @NotEmpty
    private String grade;

    private String city;
    private String street;
    private String zipcode;
}
