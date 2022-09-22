package com.springcrudedemo.workoutcrud.Controller;


import com.springcrudedemo.workoutcrud.Models.Product;
import com.springcrudedemo.workoutcrud.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/products")
public class ProductController {

    private ProductService productService;
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    public List<Product> getProducts(){
        return productService.getProducts();
    }
    @PostMapping
    public void registerProduct(@RequestBody Product product){
        productService.addUser(product);
    }
    @DeleteMapping(path = "{id}")
    public  void userDelete(@PathVariable Long id){
        productService.deleteProduct(id);
    }
    @PutMapping(path = "{id}")
    public void  updateProduct(
            @PathVariable ("id") Long id,
            @PathVariable(required = false) String name,
            @PathVariable(required = false) String description,
            @PathVariable(required = false) String price
    ){
        productService.UpdateUser(id, name, description, price);
    }
}
