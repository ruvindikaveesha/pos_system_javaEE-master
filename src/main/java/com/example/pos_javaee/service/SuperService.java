package com.example.pos_javaee.service;

import com.example.pos_javaee.dto.SuperDto;

public interface SuperService<T extends SuperDto> {
    boolean save(T dto);

    boolean update(T dto);

    T view(T dto);

    boolean delete(T dto);
}