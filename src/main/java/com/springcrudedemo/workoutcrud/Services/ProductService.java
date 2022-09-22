package com.springcrudedemo.workoutcrud.Services;


import com.springcrudedemo.workoutcrud.Models.Product;
import com.springcrudedemo.workoutcrud.Repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts(){
        return productRepository.findAll();
    }
    public void addUser(Product product) {
        Optional<Product> productOptional = productRepository.findProductByName(product.getName());
        if (productOptional.isPresent()){
            throw new IllegalStateException("product already exists");
        }
        productRepository.save(product);
        System.out.println(product);
    }
    public void deleteProduct(Long id) {
        boolean exists = productRepository.existsById(id);
        if (!exists){
            throw new IllegalStateException("user with Id" + id + "does not exist");
        }
        productRepository.deleteById(id);
    }

    public void UpdateUser(Long id, String name, String description, String price) {
        Product product = productRepository.findById(id).orElseThrow( ()->new IllegalStateException("product with id"+ id + "does not exist"));
        if(name != null && name.length()>0 && !Objects.equals(product.getName(), name));
        {
            product.setName(name);
        }
        if(description != null && description.length()>0 && !Objects.equals(product.getDescription(), description));
        {
            product.setDescription(description);
        }
        if(price != null && price.length()>0 && !Objects.equals(product.getPrice(), price));
        {
            product.setPrice(price);
        }
    }
}
