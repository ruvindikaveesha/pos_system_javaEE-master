package com.example.pos_javaee.dao.custom.impl;

import com.example.pos_javaee.dao.custom.CustomerDao;
import com.example.pos_javaee.entity.Customer;
import org.hibernate.Session;

public class CustomerDaoImpl implements CustomerDao {

    @Override
    public boolean save(Customer entity, Session session) {
        session.save(entity);
        return true;
    }

    @Override
    public boolean update(Customer entity, Session session) {
        session.update(entity);
        return true;
    }

    @Override
    public Customer view(Customer entity, Session session) {
        return session.get(Customer.class, entity.getId());
    }

    @Override
    public boolean delete(Customer entity, Session session) {
        session.delete(entity);
        return true;
    }
}
