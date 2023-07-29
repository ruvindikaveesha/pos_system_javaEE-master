package com.example.pos_javaee.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@ToString
public class Item implements SuperEntity{
    @Id
    String code;
    String description;
    Integer qty;
    Double price;

    @OneToMany(targetEntity = OrderDetails.class, mappedBy = "item")
    @ToString.Exclude
    List<OrderDetails> orderDetailsList = new ArrayList<>();
}
