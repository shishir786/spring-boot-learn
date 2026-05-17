package com.store.creatorstore.controllers;

import com.store.creatorstore.entities.Product;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @PostMapping
    public Product createProduct(@Valid @RequestBody Product product){
        return null;
    }

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @Valid @RequestBody Product product ){
        return null;
    }

    public List<Product> getProducts(){
        return null;
    }

    public Product getProductById(Long id){
        return null;
    }

    public void deleteProduct(Long id){

    }

}
