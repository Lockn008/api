package com.product.api

import org.springframework.data.annotation.Id

import javax.persistence.Entity
import javax.persistence.GeneratedValue

@Entity
class Product {

    //add @canonical, look it up

    @Id
    @GeneratedValue //(strategy = GenerationType.AUTO)
    long id;

//    @Column(nullable = false, unique = true)
    String productName;

//    @Column(nullable = false)
    float unitPrice;

//    @Column()
    int inventory;
}
