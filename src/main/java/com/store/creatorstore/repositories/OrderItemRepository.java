package com.store.creatorstore.repositories;

import com.store.creatorstore.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>
{
}
