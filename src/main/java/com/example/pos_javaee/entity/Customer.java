package com.example.pos_javaee.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer  implements SuperEntity{
    @Id
    String id;
    String name;
    String address;
    Double salary;

//    @OneToMany(targetEntity = Orders.class, mappedBy = "customer")
//    @ToString.Exclude
//    List<Orders> ordersList = new ArrayList<>();
}
