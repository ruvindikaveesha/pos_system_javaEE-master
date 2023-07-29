package com.example.pos_javaee.service.custom.impl;

import com.example.pos_javaee.dao.DaoFactory;
import com.example.pos_javaee.dao.custom.OrderDetailsDao;
import com.example.pos_javaee.dao.util.DaoTypes;
import com.example.pos_javaee.dto.OrderDetailsDto;
import com.example.pos_javaee.service.custom.OrderDetailsService;

public class OrderDetailsServiceImpl implements OrderDetailsService {
    private final OrderDetailsDao orderDetailsDao;

    public OrderDetailsServiceImpl() {
        orderDetailsDao = DaoFactory.getInstance().getDAO(DaoTypes.ORDER_DETAILS_DAO);
    }

    @Override
    public boolean save(OrderDetailsDto dto) {
        return false;
    }

    @Override
    public boolean update(OrderDetailsDto dto) {
        return false;
    }

    @Override
    public OrderDetailsDto view(OrderDetailsDto dto) {
        return null;
    }

    @Override
    public boolean delete(OrderDetailsDto dto) {
        return false;
    }
}
