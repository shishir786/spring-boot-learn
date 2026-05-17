package com.store.creatorstore.repositories;

import com.store.creatorstore.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
