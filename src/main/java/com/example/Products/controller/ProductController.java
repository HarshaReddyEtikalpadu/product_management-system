package com.example.Products.controller;

import com.example.Products.DTO.Products;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/base/products")
public class ProductController {

    private static List<Products> products = new ArrayList<>(List.of(
            new Products(1,"Apple", "1000$"),
            new Products(2,"Roku", "120$"),
            new Products(3, "DeskTop","100$")
    ));
    @GetMapping("/getAll")
    public ResponseEntity<List<Products>> getAll(){

        return ResponseEntity.ok(products);
    }
    @GetMapping("/getBy/{id}")
    public ResponseEntity<Products> getById(@PathVariable int id){
        for (Products p : products){
            if (p.getId() == id){
                return ResponseEntity.ok(p);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/create/products")
    public ResponseEntity<String> postProduct(@RequestBody Products p){
        products.add(p);
        return ResponseEntity.ok("Product Created Successfully");
    }
}
