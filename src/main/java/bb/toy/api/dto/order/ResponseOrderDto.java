package bb.toy.api.dto.order;

import bb.toy.api.domain.Address;
import bb.toy.api.domain.DeliveryStatus;
import bb.toy.api.domain.Order;
import bb.toy.api.domain.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class ResponseOrderDto {

    private Long orderId;

    private String memberId;
    private String memberName;

    private List<OrderItemDto> orderItems;

    private Address address;
    private OrderStatus orderStatus;
    private DeliveryStatus deliveryStatus;
    private String orderDate;

    public ResponseOrderDto(Order order) {
        setOrderId(order.getId());
        setMemberId(order.getMember().getId());
        setMemberName(order.getMember().getName());
        setOrderItems(order.getOrderItems().stream().map(o -> new OrderItemDto(o)).collect(Collectors.toList()));
        setAddress(order.getDelivery().getAddress());
        setOrderStatus(order.getOrderStatus());
        setDeliveryStatus(order.getDelivery().getDeliveryStatus());
        setOrderDate(order.getUpdateDate());
    }
}
