package bb.toy.api.service;

import bb.toy.api.domain.Item;
import bb.toy.api.domain.dto.item.RequestItemDto;
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
        Item item = mappingItem(requestItemDto, "C");

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
        Item item = mappingItem(requestItemDto, "U");

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

    // DTO -> Item Entity 변환
    private Item mappingItem(RequestItemDto requestItemDto, String status) {
        Item item = new Item();

        if (status.equals("C")) {
            item.setCreateDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        } else {
            item.setId(requestItemDto.getId());
        }

        item.setName(requestItemDto.getName());
        item.setPrice(requestItemDto.getPrice());
        item.setStockQuantity(requestItemDto.getStockQuantity());
        item.setUpdateDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        return item;
    }
}
