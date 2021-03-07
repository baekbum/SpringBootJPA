package bb.toy.api.repository.iface;

import bb.toy.api.domain.Item;

import java.util.List;

public interface ItemRepository {

    public void addItem(Item item);

    public Item findItem(Long id);

    public Item findItemByName(String name);

    public List<Item> findAll();

    public void deleteItem(Long id);

}
