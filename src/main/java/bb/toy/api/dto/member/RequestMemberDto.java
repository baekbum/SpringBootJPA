package bb.toy.api.dto.member;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class RequestMemberDto {
    @NotEmpty
    private String name;
    @NotEmpty
    private String password;
    private String tel;
    private String address;
    @NotEmpty
    private String rankId;
    @NotEmpty
    private String positionId;
    @NotEmpty
    private String teamId;
    private String isRetire;
}
