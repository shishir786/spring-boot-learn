package com.store.creatorstore.Product.repositories;

import com.store.creatorstore.Product.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long > {
}
