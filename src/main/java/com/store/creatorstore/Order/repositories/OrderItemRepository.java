package com.store.creatorstore.Order.repositories;

import com.store.creatorstore.Order.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>
{
}
