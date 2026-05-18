package com.store.creatorstore.Order;

import com.store.creatorstore.Order.dto.OrderItemRequest;
import com.store.creatorstore.Order.dto.OrderRequest;
import com.store.creatorstore.Order.entities.Order;
import com.store.creatorstore.Order.entities.OrderItem;
import com.store.creatorstore.Order.repositories.OrderRepository;
import com.store.creatorstore.Product.entities.Product;
import com.store.creatorstore.Product.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    List<OrderItem> orderItems = new ArrayList<>();

    BigDecimal totalPrice = BigDecimal.ZERO;

    private OrderRepository orderRepository;
    private ProductRepository productRepository;

    @Transactional
    public Order createOrder(OrderRequest  orderRequest) {
        Order order = new Order();
        order.setCustomerName(orderRequest.getCustomerName());
        order.setCustomerEmail(orderRequest.getCustomerEmail());
        order.setStatus("CONFIRMED");

        for (OrderItemRequest itemRequest : orderRequest.getOrderItems()) {
            Product product = productRepository.findById(
                    itemRequest.getProductId()
            ).orElseThrow(() -> new RuntimeException("product not found" +  itemRequest.getProductId()));
            // check the product stock
            if(product.getStockQuantity() < itemRequest.getQuantity()){
                throw new RuntimeException("stock quantity lis not enough");
            }

            //calculate price
            BigDecimal priceOfItem = product.getPrice()
                    .multiply(BigDecimal.valueOf(itemRequest.getQuantity()));

            totalPrice = totalPrice.add(priceOfItem);

            //update product table with latest stock
            product.setStockQuantity(
                    product.getStockQuantity() - itemRequest.getQuantity()
            );

            productRepository.save(product);


            // builder pattern to make object
            OrderItem orderItem = OrderItem.builder()
                    .order(order)
                    .product(product)
                    .quantity(itemRequest.getQuantity())
                    .priceAtPurchase(product.getPrice())
                    .build();

            orderItems.add(orderItem);
        }

        return order;
    }
}
