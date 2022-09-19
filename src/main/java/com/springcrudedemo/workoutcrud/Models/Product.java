package com.springcrudedemo.workoutcrud.Models;

import java.text.DecimalFormat;



public class Product {
    
    private long Id;
    private String name;
    private String description;
    private DecimalFormat Price;
    public Product() {
    }
    public Product(long id, String name, String description, DecimalFormat price) {
        Id = id;
        this.name = name;
        this.description = description;
        Price = price;
    }
    public Product(String name, String description, DecimalFormat price) {
        this.name = name;
        this.description = description;
        Price = price;
    }
    public long getId() {
        return Id;
    }
    public void setId(long id) {
        Id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public DecimalFormat getPrice() {
        return Price;
    }
    public void setPrice(DecimalFormat price) {
        Price = price;
    }
    @Override
    public String toString() {
        return "Product [Id=" + Id + ", Price=" + Price + ", description=" + description + ", name=" + name + "]";
    }

}
