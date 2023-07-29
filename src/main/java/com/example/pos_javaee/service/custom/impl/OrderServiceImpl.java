package com.example.pos_javaee.service.custom.impl;

import com.example.pos_javaee.dao.DaoFactory;
import com.example.pos_javaee.dao.custom.OrdersDao;
import com.example.pos_javaee.dao.util.DaoTypes;
import com.example.pos_javaee.dto.OrdersDto;
import com.example.pos_javaee.service.custom.OrdersService;

public class OrderServiceImpl implements OrdersService {
    private final OrdersDao ordersDao;

    public OrderServiceImpl() {
        ordersDao = DaoFactory.getInstance().getDAO(DaoTypes.ORDERS_DAO);
    }

    @Override
    public boolean save(OrdersDto dto) {
        return false;
    }

    @Override
    public boolean update(OrdersDto dto) {
        return false;
    }

    @Override
    public OrdersDto view(OrdersDto dto) {
        return null;
    }

    @Override
    public boolean delete(OrdersDto dto) {
        return false;
    }
}
