package com.store.creatorstore.Product;

import com.store.creatorstore.Product.entities.Product;
import com.store.creatorstore.Product.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product createProduct(Product product){

        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product product) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        if (product.getName() != null) {
            existingProduct.setName(product.getName());
        }
        if (product.getDescription() != null) {
            existingProduct.setDescription(product.getDescription());
        }
        if (product.getCategory() != null) {
            existingProduct.setCategory(product.getCategory());
        }
        if (product.getPrice() != null) {
            existingProduct.setPrice(product.getPrice());
        }
        if (product.getStockQuantity() != null) {
            existingProduct.setStockQuantity(product.getStockQuantity());
        }

        return productRepository.save(existingProduct);
    }


    public List<Product> getProducts(){
        return productRepository.findAll(Sort.by("id"));
    }


    public Product getProductById( Long id){
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found") );
    }


    public void deleteProduct( Long id){
        productRepository.deleteById(id);
    }
}
