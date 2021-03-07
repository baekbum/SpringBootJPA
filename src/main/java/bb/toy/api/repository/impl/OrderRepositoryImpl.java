package bb.toy.api.repository.impl;

import bb.toy.api.domain.Order;
import bb.toy.api.repository.iface.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryImpl implements OrderRepository {

    private final EntityManager em;

    @Override
    public void addOrder(Order order) {
        em.persist(order);
    }

    @Override
    public Order findOrder(Long id) {
        return em.find(Order.class, id);
    }

    @Override
    public List<Order> findOrders(String id) {
        return null;
    }

}
