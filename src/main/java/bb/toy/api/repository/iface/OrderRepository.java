package bb.toy.api.repository.iface;

import bb.toy.api.domain.Order;

import java.util.List;

public interface OrderRepository {

    public void addOrder(Order order);

    public Order findOrder(Long id); // 주문번호 id

    public List<Order> findOrderByMember(String id); // member id

}
