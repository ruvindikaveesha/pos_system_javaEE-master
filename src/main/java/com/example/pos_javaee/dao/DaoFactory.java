package com.example.pos_javaee.dao;

import com.example.pos_javaee.dao.custom.impl.CustomerDaoImpl;
import com.example.pos_javaee.dao.custom.impl.ItemDaoImpl;
import com.example.pos_javaee.dao.custom.impl.OrderDetailsDaoImpl;
import com.example.pos_javaee.dao.custom.impl.OrdersDaoImpl;
import com.example.pos_javaee.dao.util.DaoTypes;

public class DaoFactory {
    private static DaoFactory instance;

    public synchronized static DaoFactory getInstance() {
        return instance == null ? instance = new DaoFactory() : instance;
    }

    public <T extends SuperDao> T getDAO(DaoTypes type) {

        switch (type) {
            case CUSTOMER_DAO:
                return (T) new CustomerDaoImpl();
            case ITEM_DAO:
                return (T) new ItemDaoImpl();
            case ORDERS_DAO:
                return (T) new OrdersDaoImpl();
            case ORDER_DETAILS_DAO:
                return (T) new OrderDetailsDaoImpl();
            default:
                throw new RuntimeException("Error: Invalid DAO Type");
        }
    }
}
