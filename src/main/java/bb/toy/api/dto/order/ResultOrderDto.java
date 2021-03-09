package bb.toy.api.dto.order;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResultOrderDto<T> {
    private int count;
    private T data;
}
