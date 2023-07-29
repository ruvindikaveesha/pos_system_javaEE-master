package com.example.pos_javaee.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Orders")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Orders implements SuperEntity{
    @Id
    String id;

    @ManyToOne
    Customer customer;

    @OneToMany(targetEntity = OrderDetails.class, mappedBy = "orders")
    @ToString.Exclude
    List<OrderDetails> orderDetailsList = new ArrayList<>();
}
