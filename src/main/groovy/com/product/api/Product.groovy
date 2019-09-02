package com.product.api

import com.fasterxml.jackson.annotation.JsonTypeInfo

@Entity
public class Product {

    @JsonTypeInfo.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, unique = true)
    private String productName;

    @Column(nullable = false)
    private float unitPrice;

    @Column()
    private int inventory;
}
