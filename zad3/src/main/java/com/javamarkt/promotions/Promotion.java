package com.javamarkt.promotions;

import com.javamarkt.model.Product;
import java.util.List;


public interface Promotion {
    List<Product> apply(List<Product> products);
}