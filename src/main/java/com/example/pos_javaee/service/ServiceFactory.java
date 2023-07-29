package com.example.pos_javaee.service;

import com.example.pos_javaee.service.custom.impl.CustomerServiceImpl;
import com.example.pos_javaee.service.custom.impl.ItemServiceImpl;
import com.example.pos_javaee.service.custom.impl.OrderDetailsServiceImpl;
import com.example.pos_javaee.service.custom.impl.OrderServiceImpl;
import com.example.pos_javaee.service.util.ServiceTypes;

public class ServiceFactory {
    private static ServiceFactory instance;

    private ServiceFactory() {
    }

    public synchronized static ServiceFactory getInstance() {
        return instance == null ? instance = new ServiceFactory() : instance;
    }

    public <T extends SuperService> T getService(ServiceTypes type) {

        switch (type) {
            case CUSTOMER_SERVICE:
                return (T) new CustomerServiceImpl();
            case ITEM_SERVICE:
                return (T) new ItemServiceImpl();
            case ORDER_SERVICE:
                return (T) new OrderServiceImpl();
            case ORDER_DETAILS_SERVICE:
                return (T) new OrderDetailsServiceImpl();
            default:
                throw new RuntimeException("Error: Invalid service Type");
        }
    }
}
