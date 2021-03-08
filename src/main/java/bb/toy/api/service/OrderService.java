package bb.toy.api.service;

import bb.toy.api.domain.*;
import bb.toy.api.dto.order.RequestOrderDto;
import bb.toy.api.repository.iface.ItemRepository;
import bb.toy.api.repository.iface.MemberRepository;
import bb.toy.api.repository.iface.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderService {

    private final MemberRepository memberRepository;
    private final OrderRepository orderRepository;
    private final ItemRepository itemRepository;

    @Transactional(readOnly = false)
    public void addOrder(RequestOrderDto dto) {
        Member findMember = memberRepository.findMember(dto.getMemberId());
        Item findItem = itemRepository.findItem(dto.getItemId());

        Delivery delivery = new Delivery();
        delivery.setAddress(new Address(dto.getCity(), dto.getStreet(), dto.getZipcode()));
        delivery.setDeliveryStatus(DeliveryStatus.READY);

        OrderItem orderItem = OrderItem.addOrderItem(findItem, findItem.getPrice(), dto.getCount());

        Order order = Order.createOrder(findMember, delivery, orderItem);

        orderRepository.addOrder(order);
    }

    public Order findOrder(Long id) { // 주문번호 id
        Order findOrder = orderRepository.findOrder(id);
        return findOrder;
    }
}
