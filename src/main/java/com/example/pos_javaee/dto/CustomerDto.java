package com.example.pos_javaee.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDto implements SuperDto {
    private String id;
    private String name;
    private String address;
    private Double salary;
    @ToString.Exclude
    private List<OrdersDto> ordersDtoList = new ArrayList<>();
}
