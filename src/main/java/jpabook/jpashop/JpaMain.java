package jpabook.jpashop;

import jpabook.jpashop.domain.Order;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Order order= em.find(Order.class, 1L); // 1L은 Long 타입이다.
            Long memberId = order.getMemberId();// 1L은 Long 타입이다.

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close(); //영속성 컨텍스트를 종료
        }
        emf.close();
    }
}
