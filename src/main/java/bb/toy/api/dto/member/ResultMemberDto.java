package bb.toy.api.dto.member;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResultMemberDto<T> {
    private Long count;
    private T data;
}
