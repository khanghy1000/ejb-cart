package com.example.ejb_watch_cart.models;

import lombok.*;

import java.util.UUID;

@Setter
@Getter
@Builder
public class Product {
    private int id;
    private String name;
    private String mainImage;
    private Double price;
}