package com.example.pos_javaee.dao;


import com.example.pos_javaee.entity.SuperEntity;
import org.hibernate.Session;

public interface CrudDao<T extends SuperEntity> extends SuperDao {
    boolean save(T entity, Session session);

    boolean update(T entity, Session session);

    T view(T entity, Session session);

    boolean delete(T entity, Session session);
}
