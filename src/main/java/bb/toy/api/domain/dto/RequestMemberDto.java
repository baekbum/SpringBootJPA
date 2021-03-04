package bb.toy.api.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
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
