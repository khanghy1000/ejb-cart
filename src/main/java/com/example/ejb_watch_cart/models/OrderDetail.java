package com.example.ejb_watch_cart.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
public class OrderDetail {
    @Builder.Default
    private String id = UUID.randomUUID().toString();
    private Product product;
    private Integer quantity;
    private Double unitPrice;
}