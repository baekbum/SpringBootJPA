/*
package bb.toy.api.service;

import bb.toy.api.domain.Order;
import bb.toy.api.dto.order.RequestOrderDto;
import bb.toy.api.repository.iface.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderService {

    private final OrderRepository orderRepository;

    public Long addOrder(RequestOrderDto RequestOrderDto) {


       // orderRepository.addOrder(order);
        return 0L;
    }

    public Order findOrder(Long id) { // 주문번호 id
        Order findOrder = orderRepository.findOrder(id);
        return findOrder;
    }

    // DTO -> Member Entity 변환
    //private Order mappingOrderItem(RequestOrderDto requestOrderDto, String status) {
    //    Order order = new Order();
    //
    //    orderItem.
    //
    //    return orderItem;
    //}

}

 */
