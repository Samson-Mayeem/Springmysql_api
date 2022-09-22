package com.springcrudedemo.workoutcrud.Models;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;


@Entity
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "product_sequence")
    private long Id;
    private String name;
    private String description;
    private String Price;
    public Product() {
    }
    public Product(long id, String name, String description, String price) {
        Id = id;
        this.name = name;
        this.description = description;
        this.Price = price;
    }
    public Product(String name, String description, String price) {
        this.name = name;
        this.description = description;
        this.Price = price;
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
    public String getPrice() {
        return Price;
    }
    public void setPrice(String price) {
        this.Price = price;
    }
    @Override
    public String toString() {
        return "Product [Id=" + Id + ", Price=" + Price + ", description=" + description + ", name=" + name + "]";
    }

}
