package com.example.bookexample.infrastructure;

import com.example.bookexample.domain.Item;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemRepository {

    @PersistenceContext
    private EntityManager em;

    public Item save(Item item) {
        if(item.getId() == null){
            em.persist(item);
            return item;
        }
        else {
            return em.merge(item);
        }
    }

    public Item findOne(Long id) {
        return em.find(Item.class, id);
    }

    public List<Item> findAll() {
        return em.createQuery("select i from Item i", Item.class).getResultList();
    }

    public List<Item> findByName(String name) {
        return em.createQuery("select i from Item i where name = :name", Item.class)
                .setParameter("name", name)
                .getResultList();
    } // 여기서 이름에대한 result 를 찾을때 %name% 으로 찾고싶은데 방법찾기

}
