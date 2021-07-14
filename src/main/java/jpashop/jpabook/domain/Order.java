package jpashop.jpabook.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="ORDERS")
public class Order {
    @Id @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")//외래키 관리하겠다고 지정.
    private Member member;

    @OneToMany(mappedBy = "order")//매핑하는 상대 객체에서 필드 이름(데이터 변수명!!!)
    private List<OrderItem> orderItems = new ArrayList<>();//주문:주문상품 = 주문1 주문상품 N개

    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;


    public void addOrderItem(OrderItem orderItem){//연관관계 편의메서드
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}