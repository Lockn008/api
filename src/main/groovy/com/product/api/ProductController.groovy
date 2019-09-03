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
    public Iterable findAll() {
        return productList.findAll();
    }

    @GetMapping("/title/{bookTitle}")
    public List findByTitle(@PathVariable String productName) {
        return productList.findByTitle(productName);
    }

    @GetMapping("/{id}")
    public Product findOne(@PathVariable Long id) {
        return productList.findById(id)
            .orElseThrow(ProductNotFoundException::new);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product create(@RequestBody Product product) {
        return productList.save(product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productList.findById(id)
            .orElseThrow(ProductNotFoundException::new);
        productList.deleteById(id);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@RequestBody Product product, @PathVariable Long id) {
        id (product.getId() != id) {
            throw new ProductIdMismatchException();
        }
        productList.findById(id)
            .orElseThrow(ProductNotFoundException::new);
        return productList.save(product);
    }
}
