package com.example.pos_javaee.dao.custom.impl;

import com.example.pos_javaee.dao.custom.OrderDetailsDao;
import com.example.pos_javaee.entity.OrderDetails;
import org.hibernate.Session;

public class OrderDetailsDaoImpl implements OrderDetailsDao {
    @Override
    public boolean save(OrderDetails entity, Session session) {
            session.save(entity);
            return true;
    }

    @Override
    public boolean update(OrderDetails entity, Session session) {
        return false;
    }

    @Override
    public OrderDetails view(OrderDetails entity, Session session) {
        return null;
    }

    @Override
    public boolean delete(OrderDetails entity, Session session) {
        return false;
    }
}
