package com.product.api

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PutMapping

@RestController
@RequestMapping("/api/books")
class ProductController {

    @Autowired
    private ProductList productList;

    @GetMapping
    Iterable findAll() {
        return productList.findAll();
    }

    @GetMapping("/title/{bookTitle}")
    List findByTitle(@PathVariable String productName) {
        return productList.findByTitle(productName);
    }

    @GetMapping("/{id}")
    Product findOne(@PathVariable Long id) {
        return productList.findById(id)
//            .orElseThrow(new ProductNotFoundException())
    }

    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    Product create(@RequestBody Product product) {
//        return productList.save(product);
//    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productList.findById(id)
//            .orElseThrow(new ProductNotFoundException());
        productList.deleteById(id);
    }

    @PutMapping("/{id}")
    Product updateProduct(@RequestBody Product product, @PathVariable Long id) {
        id (product.getId() != id) {
//            throw new ProductIdMismatchException();
        }
        productList.findById(id)
//            .orElseThrow(new ProductNotFoundException())
        return productList.save(product);
    }
}
