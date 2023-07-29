package com.example.pos_javaee.service.custom.impl;


import com.example.pos_javaee.dao.DaoFactory;
import com.example.pos_javaee.dao.custom.CustomerDao;
import com.example.pos_javaee.dao.util.DaoTypes;
import com.example.pos_javaee.dto.CustomerDto;
import com.example.pos_javaee.entity.Customer;
import com.example.pos_javaee.service.custom.CustomerService;
import com.example.pos_javaee.service.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CustomerServiceImpl implements CustomerService {
    private final CustomerDao customerDao;

    public CustomerServiceImpl() {
        customerDao = DaoFactory.getInstance().getDAO(DaoTypes.CUSTOMER_DAO);
    }

    @Override
    public boolean save(CustomerDto dto) throws RuntimeException{
//        System.out.println("service: save");

        Customer customer = new Customer();
        customer.setId(dto.getId());
        customer.setName(dto.getName());
        customer.setSalary(dto.getSalary());
        customer.setAddress(dto.getAddress());

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try (session) {
            customerDao.save(customer, session);
            transaction.commit();
            System.out.println("transaction Done");
            return true;
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean update(CustomerDto dto)throws RuntimeException {
        Customer customer = new Customer();
        customer.setId(dto.getId());
        customer.setName(dto.getName());
        customer.setSalary(dto.getSalary());
        customer.setAddress(dto.getAddress());

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try (session) {
            customerDao.update(customer, session);
            transaction.commit();
            return true;
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public CustomerDto view(CustomerDto dto)throws RuntimeException  {
        try(Session session = FactoryConfiguration.getInstance().getSession()) {
            Customer customer = new Customer();
            customer.setId(dto.getId());
            Customer viewed = customerDao.view(customer, session);
            dto.setId(viewed.getId());
            dto.setName(viewed.getName());
            dto.setSalary(viewed.getSalary());
            dto.setAddress(viewed.getAddress());
            System.out.println("service "+dto);
            return dto;
        }catch (RuntimeException e ){
            throw  new RuntimeException(e);
        }

    }

    @Override
    public boolean delete(CustomerDto dto) throws RuntimeException {
        Customer customer = new Customer();
        customer.setId(dto.getId());

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try (session) {
            customerDao.delete(customer, session);
            transaction.commit();
            return true;
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
