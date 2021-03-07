package bb.toy.api.repository.impl;

import bb.toy.api.domain.Item;
import bb.toy.api.repository.iface.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemRepositoryImpl implements ItemRepository {

    private final EntityManager em;

    @Override
    public void addItem(Item item) {
        em.persist(item);
    }

    @Override
    public Item findItem(Long id) {
        Item findItem = em.find(Item.class, id);
        return findItem;
    }

    @Override
    public Item findItemByName(String name) throws NoResultException {
        return em.createQuery("select i from Item i where i.name = :name", Item.class)
                .setParameter("name", name)
                .getSingleResult();
    }

    @Override
    public List<Item> findAll() {
        return em.createQuery("select i from Item i", Item.class)
                .getResultList();
    }

    @Override
    public void deleteItem(Long id) {
        Item findItem = em.find(Item.class, id);
        em.remove(findItem);
    }
}
