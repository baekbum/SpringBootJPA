package bb.toy.api.dto.item;

import bb.toy.api.domain.Item;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class ResponseItemDto {

    private Long id;
    private String name;
    private int price;
    private int stockQuantity;

    public ResponseItemDto (Item item) {
        setId(item.getId());
        setName(item.getName());
        setPrice(item.getPrice());
        setStockQuantity(item.getStockQuantity());
    }

}
