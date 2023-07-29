package com.example.pos_javaee.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class OrderDetailsDto implements SuperDto {
    private ItemDto itemDto;
    private OrdersDto ordersDto;
    private Integer qty;
    private Integer id;
}
