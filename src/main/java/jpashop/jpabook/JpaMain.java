package jpashop.jpabook;

import jpashop.jpabook.domain.Member;
import jpashop.jpabook.domain.Order;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");//설정파일에서 설정한 이름 가져온다

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {//현재의 설계로 member에 접근하는 것.
            Order order = em.find(Order.class, 1L);
            Long memberId = order.getMemberId();

            //Member member1 = order.getMember();//OOP는 이렇게 해서 바로 member를 꺼낼 수 잇어야함.

            Member member = em.find(Member.class, memberId);
            tx.commit();
        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close();//em이 결국 DB 연결을 담당하기 때문에 자원을 다 쓰고 작업 끝나면 닫아줘야한다!!
        }
        emf.close();//애플리케이션 종료 또는 WAS 내려갈 때 emf도 닫아준다!
    }
}
