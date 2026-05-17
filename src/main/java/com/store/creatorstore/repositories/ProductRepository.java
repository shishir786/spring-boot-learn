package com.store.creatorstore.repositories;

import com.store.creatorstore.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long > {
}
