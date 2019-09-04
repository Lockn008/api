package com.product.api

import org.springframework.data.repository.CrudRepository

interface ProductList extends CrudRepository<Product, Long> {
    List<Product> findByTitle(String title);
}
