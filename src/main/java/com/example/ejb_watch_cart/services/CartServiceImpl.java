package com.example.ejb_watch_cart.services;

import com.example.ejb_watch_cart.models.CartItem;
import com.example.ejb_watch_cart.models.Order;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateful;
import jakarta.enterprise.context.SessionScoped;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Stateful
@SessionScoped
public class CartServiceImpl implements CartService, Serializable {
    @EJB
    private ProductService productService;
    @EJB
    private OrderService orderService;

    private List<CartItem> cartItems = new ArrayList<>();

    @Override
    public List<CartItem> getCartItems() {
        return cartItems;
    }

    @Override
    public Double getTotal() {
        return cartItems
                .stream()
                .map(cartItem -> cartItem.getProduct().getPrice() * cartItem.getQuantity())
                .reduce(0.0, Double::sum);
    }

    @Override
    public void addToCart(int productId, Integer quantity) {
        cartItems
                .stream()
                .filter(cartItem -> cartItem.getProduct().getId() == productId)
                .findFirst()
                .ifPresentOrElse(
                        cartItem -> cartItem.increaseQuantity(quantity),
                        () -> cartItems.add(CartItem
                                .builder()
                                .product(productService.getProduct(productId))
                                .quantity(quantity)
                                .build())
                );
    }

    @Override
    public void increaseQuantity(int productId) {
        cartItems
                .stream()
                .filter(cartItem -> cartItem.getProduct().getId() == productId)
                .findFirst()
                .ifPresent(CartItem::increaseQuantity);
    }

    @Override
    public void decreaseQuantity(int productId) {

        cartItems
                .stream()
                .filter(cartItem -> cartItem.getProduct().getId() == productId)
                .filter(cartItems -> cartItems.getQuantity() > 1)
                .findFirst()
                .ifPresent(CartItem::decreaseQuantity);
    }

    @Override
    public void removeFromCart(int productId) {
        cartItems.removeIf(cartItem -> cartItem.getProduct().getId() == productId);
    }

    @Override
    public Order checkout() {
        Order newOrder = Order
                .builder()
                .orderDetails(cartItems
                        .stream()
                        .map(CartItem::toOrderDetail)
                        .toList())
                .total(getTotal())
                .build();
        orderService.addOrder(newOrder);
        cartItems.clear();
        return newOrder;
    }
}
