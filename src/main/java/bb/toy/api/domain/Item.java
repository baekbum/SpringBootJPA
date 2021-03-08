package bb.toy.api.domain;

import bb.toy.api.dto.item.RequestItemDto;
import bb.toy.api.dto.member.RequestMemberDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Getter @Setter
@SequenceGenerator(name = "ITEM_SEQ_GENERATOR", sequenceName = "ITEM_SEQ", initialValue = 1, allocationSize = 1)
public class Item {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ITEM_SEQ_GENERATOR")
    @Column(name = "item_id")
    private Long id;
    @Column(name = "item_name")
    private String name;
    private int price;
    private int stockQuantity;

    private String createDate;
    private String updateDate;

    //@JoinColumn(name = "category_id")
    //private Category category;

    public static Item addItem(RequestItemDto dto, String status) {
        Item item = new Item();

        if (status.equals("C")) {
            item.setCreateDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        } else {
            item.setId(dto.getId());
        }

        item.setName(dto.getName());
        item.setPrice(dto.getPrice());
        item.setStockQuantity(dto.getStockQuantity());
        item.setUpdateDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        return item;
    }

    public void addStock(int count) {
        stockQuantity += count;
    }

    public void removeStock(int count) {
        int stock = stockQuantity - count;

        if (stock < 0 ) {
            throw new IllegalStateException("재고가 부족합니다.");
        }

        stockQuantity = stock;
    }
}