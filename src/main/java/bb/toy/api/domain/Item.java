package bb.toy.api.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

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
}