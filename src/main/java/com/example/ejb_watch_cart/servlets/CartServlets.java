package com.example.ejb_watch_cart.servlets;

import com.example.ejb_watch_cart.models.Order;
import com.example.ejb_watch_cart.services.CartService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class CartServlets {
    @WebServlet("/cart")
    public static class CartDetailsServlet extends HttpServlet {
        @Inject
        CartService cartService;

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.setAttribute("cart", cartService.getCartItems());
            req.setAttribute("total", cartService.getTotal());
            req.getRequestDispatcher("/views/cart.jsp").forward(req, resp);
        }
    }
    
    @WebServlet("/cart/add")
    public static class AddToCartServlet extends HttpServlet {
        @Inject
        CartService cartService;

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String productId = req.getParameter("productId");
            String quantity = req.getParameter("quantity");
            cartService.addToCart(Integer.parseInt(productId), Integer.parseInt(quantity));
            resp.sendRedirect("/cart");
        }
    }
    
    @WebServlet("/cart/increase")
    public static class IncreaseQuantityServlet extends HttpServlet {
        @Inject
        CartService cartService;

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String productId = req.getParameter("productId");
            cartService.increaseQuantity(Integer.parseInt(productId));
            resp.sendRedirect("/cart");
        }
    }
    
    @WebServlet("/cart/decrease")
    public static class DecreaseQuantityServlet extends HttpServlet {
        @Inject
        CartService cartService;

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String productId = req.getParameter("productId");
            cartService.decreaseQuantity(Integer.parseInt(productId));
            resp.sendRedirect("/cart");
        }
    }
    
    @WebServlet("/cart/remove")
    public static class RemoveFromCartServlet extends HttpServlet {
        @Inject
        CartService cartService;

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String productId = req.getParameter("productId");
            cartService.removeFromCart(Integer.parseInt(productId));
            resp.sendRedirect("/cart");
        }
    }
    
    @WebServlet("/cart/checkout")
    public static class CheckoutServlet extends HttpServlet {
        @Inject
        CartService cartService;

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            Order newOrder = cartService.checkout();
            resp.sendRedirect("/orders/details/" + newOrder.getId());
        }
    }
}
