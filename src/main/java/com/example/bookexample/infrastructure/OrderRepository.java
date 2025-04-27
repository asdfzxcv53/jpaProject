package com.example.bookexample.infrastructure;

import com.example.bookexample.domain.Member;
import com.example.bookexample.domain.Order;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepository {

    @PersistenceContext
    private EntityManager em;

    public Order save(Order order) {
        em.persist(order);

        return order;
    }

    public Order findById(Long id) {
        return em.find(Order.class, id);
    }

    public List<Order> findAll() {
        return em.createQuery("select o from Order o", Order.class).getResultList();
    }

    public List<Order> findByMemberId(Long memberId) {
        Member member = em.find(Member.class, memberId);

        return em.createQuery("select o from Order o where o.member = member", Order.class)
                .getResultList();
    }
}
