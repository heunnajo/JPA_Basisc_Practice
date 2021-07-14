package jpashop.jpabook.domain;

import javax.persistence.*;

@Entity
public class Item {
    @Id
    @GeneratedValue
    @Column(name = "ITEM_ID")
    private Long id;

    private int price;
    private int stockQuantity;

    @OneToMany(mappedBy = "ORDER_ITEM_ID")
    private OrderItem orderItem;
}
