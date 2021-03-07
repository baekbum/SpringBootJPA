package bb.toy.api.dto.item;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseItemDto {

    private Long id;
    private String name;
    private int price;
    private int stockQuantity;

}
