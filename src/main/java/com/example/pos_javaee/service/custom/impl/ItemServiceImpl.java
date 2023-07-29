package com.example.pos_javaee.service.custom.impl;


import com.example.pos_javaee.dao.DaoFactory;
import com.example.pos_javaee.dao.custom.ItemDao;
import com.example.pos_javaee.dao.util.DaoTypes;
import com.example.pos_javaee.dto.ItemDto;
import com.example.pos_javaee.entity.Item;
import com.example.pos_javaee.service.custom.ItemService;
import com.example.pos_javaee.service.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ItemServiceImpl implements ItemService {
    private final ItemDao itemDao;

    public ItemServiceImpl() {
        itemDao = DaoFactory.getInstance().getDAO(DaoTypes.ITEM_DAO);
    }

    @Override
    public boolean save(ItemDto dto) {
        Item item = new Item();

        item.setCode(dto.getCode());
        item.setDescription(dto.getDescription());
        item.setPrice(dto.getPrice());
        item.setQty(dto.getQty());

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try (session) {
            itemDao.save(item, session);
            transaction.commit();
            return true;
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public boolean update(ItemDto dto) {
        Item item = new Item();
        item.setCode(dto.getCode());
        item.setDescription(dto.getDescription());
        item.setPrice(dto.getPrice());
        item.setQty(dto.getQty());

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try (session) {
            itemDao.update(item, session);
            transaction.commit();
            return true;
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ItemDto view(ItemDto dto) {
        return null;
    }

    @Override
    public boolean delete(ItemDto dto) {
        Item item = new Item();
        item.setCode(dto.getCode());
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try (session) {
            itemDao.delete(item, session);
            transaction.commit();
            return true;
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
