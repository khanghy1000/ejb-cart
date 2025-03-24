package com.example.ejb_watch_cart.servlets;

import com.example.ejb_watch_cart.models.Order;
import com.example.ejb_watch_cart.services.OrderService;
import jakarta.ejb.EJB;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class OrderServlets {
    @WebServlet("/orders/details/*")
    public static class OrderDetailsServlet extends HttpServlet {
        @EJB
        OrderService orderService;

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String orderId = req.getPathInfo().substring(1);
            Order order = orderService.getOrder(orderId);
            req.setAttribute("order", order);
            req.getRequestDispatcher("/views/order.jsp").forward(req, resp);
        }
    }
}
