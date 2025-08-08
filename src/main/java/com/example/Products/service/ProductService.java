package com.example.Products.service;

import com.example.Products.DTO.Products;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private static List<Products> products = new ArrayList<>(List.of(
            new Products(1,"Apple", "1000$","Gadgets"),
            new Products(2,"Roku", "120$","TV & Appliances"),
            new Products(3, "DeskTop","100$","Electronics"),
            new Products(4,"eOzark Trial","300$","ebikes")
    ));

    public List<Products> getAllProducts(){
        return products;
    }

    public Optional<Products> getProductById(int id){
        for (Products p : products){
            if (p.getId() == id){
                return Optional.of(p);
            }
        } return Optional.empty();
    }

    public void addProduct(Products p){
        products.add(p);
    }
}
