package com.example.ejb_watch_cart.services;

import com.example.ejb_watch_cart.models.Order;
import jakarta.data.repository.OrderBy;
import jakarta.ejb.Stateful;
import jakarta.ejb.Stateless;

import java.util.ArrayList;
import java.util.List;

@Stateless
public class OrderServiceImpl implements OrderService {
    List<Order> orders = new ArrayList<>();

    @Override
    public Order getOrder(String id) {
        return orders.stream().filter(order -> order.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<Order> listOrders() {
        return orders;
    }

    @Override
    public void addOrder(Order order) {
        orders.add(order);
    }
}
