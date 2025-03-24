package com.example.ejb_watch_cart.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@Builder
public class CartItem {
    @Builder.Default
    private String id = UUID.randomUUID().toString();
    private Product product;
    private Integer quantity;

    public void increaseQuantity() {
        quantity++;
    }


    public void increaseQuantity(Integer quantity) {
        this.quantity += quantity;
    }

    public void decreaseQuantity() {
        quantity--;
    }

    public void decreaseQuantity(Integer quantity) {
        this.quantity -= quantity;
    }

    public OrderDetail toOrderDetail() {
        return OrderDetail.builder().product(product).quantity(quantity).unitPrice(product.getPrice()).build();
    }
}
