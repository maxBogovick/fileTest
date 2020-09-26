package com.sample.ejb;

import com.sample.jpa.entity.UserEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class UserBean {
    @PersistenceContext(unitName = "myUnit")
    EntityManager entityManager;

    public void saveUser(UserEntity user){
        entityManager.persist(user);

    }
}
