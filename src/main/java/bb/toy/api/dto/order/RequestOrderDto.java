package bb.toy.api.dto.order;

import lombok.Data;

@Data
public class RequestOrderDto {

    private String memberId;
    private Long orderId;

    private Long itemId;
    private int count;

    private String city;
    private String street;
    private String zipcode;
}
