package com.example.Products.DTO;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Products {

    @Id
    private int id;
    private String productName;
    private String price;
    private String category;

    public Products(int id, String name, String price, String category) {
        this.id = id;
        this.productName = name;
        this.price = price;
        this.category = category;
    }
}
