package bb.toy.api.domain;

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
    private Long price;
    private int count;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
}