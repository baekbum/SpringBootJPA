package bb.toy.api.service;

import bb.toy.api.domain.Order;
import bb.toy.api.repository.iface.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderService {

    private final OrderRepository orderRepository;

    public Long addOrder(Order order) {
        orderRepository.addOrder(order);
        return order.getId();
    }

    public Order findOrder(Long id) { // 주문번호 id
        Order findOrder = orderRepository.findOrder(id);
        return findOrder;
    }

}
