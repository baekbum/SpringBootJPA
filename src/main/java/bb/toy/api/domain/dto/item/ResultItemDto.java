package bb.toy.api.domain.dto.item;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResultItemDto<T> {
    private int count;
    private T data;
}
