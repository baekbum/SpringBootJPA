package bb.toy.api.controller;

import bb.toy.api.domain.Item;
import bb.toy.api.dto.item.RequestItemDto;
import bb.toy.api.dto.item.ResponseItemDto;
import bb.toy.api.dto.item.ResultItemDto;
import bb.toy.api.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @PostMapping("/api/item")
    public Long saveItem(@RequestBody @Valid RequestItemDto requestItemDto) {
        Long id = itemService.save(requestItemDto);

        return id;
    }

    @GetMapping("/api/item/{id}")
    public ResponseItemDto findItem(@PathVariable("id") Long id) {
        Item findItem = itemService.findItem(id);
        ResponseItemDto dto = new ResponseItemDto(findItem);

        return dto;
    }

    @GetMapping("/api/item/all")
    public ResultItemDto findItems() {
        List<Item> items = itemService.findAll();
        List<ResponseItemDto> dtos = items.stream()
                                          .map(o -> new ResponseItemDto(o))
                                          .collect(Collectors.toList());

        return new ResultItemDto(dtos.size(), dtos);
    }

    @PutMapping("/api/item")
    public void updateItem(@RequestBody @Valid RequestItemDto requestItemDto) {
        itemService.update(requestItemDto);
    }

    @DeleteMapping("/api/item/{id}")
    public void deleteItem(@PathVariable("id") Long id) {
        itemService.delete(id);
    }
}
