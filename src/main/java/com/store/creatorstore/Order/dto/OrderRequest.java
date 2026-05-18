package com.store.creatorstore.Order.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderRequest {
    @NotBlank(message= "customer name is required")
    private String customerName;

    @NotBlank(message = "customer email is required")
    @Email(message = "invalid email format")
    private String customerEmail;

    @Valid
    @NotEmpty(message = "order must contain at least one item")
    private List<OrderItemRequest> orderItems;


}
