package jpashop.jpabook.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();

}
