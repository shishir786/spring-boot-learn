package com.store.creatorstore.Order.repositories;

import com.store.creatorstore.Order.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
