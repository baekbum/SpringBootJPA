package bb.toy.api.domain.dto.order;

import lombok.Data;

@Data
public class RequestOrderDto {

    private String memberId;
    private Long orderId;
}
