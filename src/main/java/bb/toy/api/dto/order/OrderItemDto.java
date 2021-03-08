package bb.toy.api.dto.order;

import bb.toy.api.domain.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class OrderItemDto {

    private String itemName;
    private int price;
    private int count;
    private int totalPrice;

    public OrderItemDto (OrderItem orderItem) {
        setItemName(orderItem.getItem().getName());
        setPrice(orderItem.getPrice());
        setCount(orderItem.getCount());
        setTotalPrice(orderItem.getTotalPrice());
    }
}
