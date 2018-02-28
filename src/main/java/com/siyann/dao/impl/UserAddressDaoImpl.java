package com.siyann.dao.impl;

import com.siyann.dao.custom.UserAddressCustomDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


public class UserAddressDaoImpl implements UserAddressCustomDao {
    @PersistenceContext
    EntityManager em;

    @Override
    public void update(Long id, Long userid) {
        Query query = em.createNativeQuery("call update_default_address(?,?)").setParameter(1, id).setParameter(2, userid);
        query.executeUpdate();
    }
}
