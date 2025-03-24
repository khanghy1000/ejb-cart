package com.example.ejb_watch_cart.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@Builder
public class Order {
    @Builder.Default
    private String id = UUID.randomUUID().toString();
    @Builder.Default
    private LocalDateTime orderTime = LocalDateTime.now();
    private Double total;
    private List<OrderDetail> orderDetails;

    public void addItem(OrderDetail orderDetail) {
        orderDetails.add(orderDetail);
    }

    public Double getTotal() {
        return orderDetails
                .stream()
                .map(orderDetail -> orderDetail.getUnitPrice() * orderDetail.getQuantity())
                .reduce(0.0, Double::sum);
    }
}