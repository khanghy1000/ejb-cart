package com.example.ejb_watch_cart.services;

import com.example.ejb_watch_cart.models.CartItem;
import com.example.ejb_watch_cart.models.Order;
import jakarta.ejb.Local;

import java.util.List;

@Local
public interface CartService {
    public List<CartItem> getCartItems();
    public Double getTotal();
    public void addToCart(int productId, Integer quantity);
    public void increaseQuantity(int productId);
    public void decreaseQuantity(int productId);
    public void removeFromCart(int productId);
    public Order checkout();
}
