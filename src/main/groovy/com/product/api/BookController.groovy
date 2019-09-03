package com.product.api

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/books")
class BookController {

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
    public Book findOne(@PathVariable Long id) {
        return productList.findById(id)
            .orElseThrow(ProductNotFoundException::new);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book create(@RequestBody Product product) {
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
