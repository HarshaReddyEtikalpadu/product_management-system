package com.example.Products.controller;

import com.example.Products.DTO.Products;
import com.example.Products.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/base/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Products>> getAll() {
        List<Products> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/getBy/{id}")
    public ResponseEntity<Optional<Products>> getById(@PathVariable int id) {
        Optional<Products> p = productService.getProductById(id);
        return p.map(products -> ResponseEntity.ok(p)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/create/products")
    public ResponseEntity<String> postProduct(@RequestBody Products p) {
        productService.addProduct(p);
        return ResponseEntity.status(HttpStatus.CREATED).body("Product Created Successfully");
    }
}
