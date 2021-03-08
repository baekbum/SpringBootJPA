package bb.toy.api.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@SequenceGenerator(name = "ORDER_ITEM_SEQ_GENERATOR", sequenceName = "ORDER_ITEM_SEQ", initialValue = 1, allocationSize = 1)
public class OrderItem {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORDER_ITEM_SEQ_GENERATOR")
    @Column(name = "order_item_id")
    private Long id;
    private int price;
    private int count;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    public static OrderItem addOrderItem(Item item, int price, int count) {
        OrderItem orderItem = new OrderItem();
        orderItem.setItem(item);
        orderItem.setPrice(price);
        orderItem.setCount(count);

        item.removeStock(count);

        return orderItem;
    }

    public void cancel() {
        getItem().addStock(getCount());
    }

    public int getTotalPrice() {
        return getPrice() * getCount();
    }
}