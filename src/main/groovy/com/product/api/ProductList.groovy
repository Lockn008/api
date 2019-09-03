package com.product.api

import java.util.List

import org.springframework.data.repository.CrudRepository

public interface ProductList extends CrudRepository<Product, Long> {
    List<Product> findByTitle(String title);
}
