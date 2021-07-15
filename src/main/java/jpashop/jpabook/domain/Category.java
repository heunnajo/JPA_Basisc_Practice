package jpashop.jpabook.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.*;

@Entity
public class Category extends BaseEntity  {
    @Id
    @GeneratedValue
    @Column(name="CATEGORY_ID")
    private Long id;

    private String name;

    //셀프 매핑 가능 : 자식 입장에서 부모 하나
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name="PARENT_ID")
    private Category parent;

    @OneToMany(mappedBy = "parent") // 셀프 매핑 : 본인 입장에서 자식 여럿
    private List<Category> child = new ArrayList<>();

    @ManyToMany//중간 테이블 생성해야한다!카테고리 객체를 주인으로 잡는다면 매핑관계 설정해주고, 상대 객체는 mappedBy
    @JoinTable(name="CATEGORY_ITEM",
            joinColumns = @JoinColumn(name="CATEGORY_ID"),//내가 조인하는 칼럼(필드)
            inverseJoinColumns = @JoinColumn(name="ITEM_ID")//상대편 조인하는 칼럼(필드)
    )
    private List<Item> items = new ArrayList<>();//카테고리와 상품은 다대다 관계.

}
