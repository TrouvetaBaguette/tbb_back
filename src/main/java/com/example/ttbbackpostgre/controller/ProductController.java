package com.example.ttbbackpostgre.controller;

import com.example.ttbbackpostgre.entity.Product;
import com.example.ttbbackpostgre.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5050")
@RestController
public class ProductController {
    @Autowired
    private ProductService service;


    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {
        return service.saveProduct(product);
    }

    @GetMapping("/productById/{id}")
    public Product findProductById(@PathVariable int id) {
        return service.getProductById(id);
    }

    @GetMapping("/product/{name}")
    public Product findProductByLabel(@PathVariable String name) {
        return service.getProductByLabel(name);
    }

    @PutMapping("/product/update")
    public Product updateProduct(@RequestBody Product product) {
        return service.updateProduct(product);
    }

    @DeleteMapping("/product/delete/{id}")
    public void deleteProduct(@PathVariable int id) {
        service.deleteProduct(id);
    }
}
