package com.example.pos_javaee.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@ToString
public class OrderDetails implements SuperEntity{
    @ManyToOne
    Item item;
    @ManyToOne
    Orders orders;
    Integer qty;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
}
