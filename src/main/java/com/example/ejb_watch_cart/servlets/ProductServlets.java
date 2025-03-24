package com.example.ejb_watch_cart.servlets;

import com.example.ejb_watch_cart.services.ProductService;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


public class ProductServlets {
    @WebServlet("/products")
    public static class ListProductServlet extends HttpServlet {
        @EJB
        ProductService productService;

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.setAttribute("products", productService.listProducts());
            req.getRequestDispatcher("/views/products.jsp").forward(req, resp);
        }
    }
    
    @WebServlet("/products/details/*")
    public static class ProductDetailsServlet extends HttpServlet {
        @EJB
        ProductService productService;

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String pathInfo = req.getPathInfo();
            String[] pathParts = pathInfo.split("/");
            int productId = Integer.parseInt(pathParts[1]);
            req.setAttribute("product", productService.getProduct(productId));
            req.getRequestDispatcher("/views/product-details.jsp").forward(req, resp);
        }
    }
}
