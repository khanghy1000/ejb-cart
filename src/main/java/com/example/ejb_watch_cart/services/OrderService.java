package com.example.ejb_watch_cart.services;

import com.example.ejb_watch_cart.models.Order;
import jakarta.ejb.Local;

import java.util.List;

@Local
public interface OrderService {
    public Order getOrder(String id);
    public List<Order> listOrders();
    public void addOrder(Order order);
}
