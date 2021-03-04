package bb.toy.api.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResultMemberDto<T> {
    private int count;
    private T data;
}
