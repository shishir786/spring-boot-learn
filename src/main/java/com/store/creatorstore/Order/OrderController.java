package com.store.creatorstore.Order;

import com.store.creatorstore.Order.dto.OrderRequest;
import com.store.creatorstore.Order.dto.OrderStatusRequest;
import com.store.creatorstore.Order.entities.Order;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;



    @PostMapping
    public Order create(@RequestBody @Valid OrderRequest orderRequest) {
        return orderService.createOrder(orderRequest);
    }

    @GetMapping
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id){
        return orderService.getOrderById(id);
    }

    @PatchMapping("/{id}")
    public Order updateStatus(@PathVariable Long id,  @RequestBody OrderStatusRequest orderStatusRequest  ){
        return orderService.changeOrderStatus(id, orderStatusRequest.getStatus() );

    }

}
