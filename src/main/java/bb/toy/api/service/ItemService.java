package bb.toy.api.service;

import bb.toy.api.domain.Item;
import bb.toy.api.dto.item.RequestItemDto;
import bb.toy.api.repository.iface.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional(readOnly = false)
    public Long save(RequestItemDto requestItemDto) {
        Item item = Item.addItem(requestItemDto, "C");

        itemRepository.addItem(item);
        return item.getId();
    }

    public Item findItem(Long id) {
        Item findItem = itemRepository.findItem(id);
        return findItem;
    }

    public Item findItemByName(String name) {
        Item findItem = itemRepository.findItemByName(name);
        return findItem;
    }

    public List<Item> findAll() {
        List<Item> items = itemRepository.findAll();
        return items;
    }

    @Transactional(readOnly = false)
    public void update(RequestItemDto requestItemDto) {
        Item item = Item.addItem(requestItemDto, "U");

        Item findItem = itemRepository.findItem(item.getId());
        findItem.setName(item.getName());
        findItem.setPrice(item.getPrice());
        findItem.setStockQuantity(item.getStockQuantity());
        findItem.setUpdateDate(item.getUpdateDate());
    }

    @Transactional(readOnly = false)
    public void delete(Long id) {
        itemRepository.deleteItem(id);
    }
}
