package com.example.ejb_watch_cart.services;

import com.example.ejb_watch_cart.models.Product;
import jakarta.ejb.Local;

import java.util.List;

@Local
public interface ProductService {
    public List<Product> listProducts();
    public Product getProduct(int id);
    public void addProduct(Product product);
    public void updateProduct(Product product);
    public void removeProduct(int id);
    
}
