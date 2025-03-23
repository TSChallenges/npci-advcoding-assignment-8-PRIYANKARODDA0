package com.mystore.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;
import jakarta.validation.Valid;



@Entity
public class Product {

    @Id
    private Integer id;

    @NotBlank(message = "Product name must not be empty")
    private String name;

    @NotBlank(message = "Category must not be empty")
    private String category;

    @Min(value = 100, message = "Price must be at least 100")
    @Max(value = 50000, message = "Price must be less than or equal to 50000")
    private Double price;

    @Min(value = 10, message = "Stock quantity must be at least 10")
    @Max(value = 500, message = "Stock quantity must be less than or equal to 500")
    private Integer stockQuantity;

    public Product() {
    }

    public Product(Integer id, String name, String category, Double price, Integer stockQuantity) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
}
