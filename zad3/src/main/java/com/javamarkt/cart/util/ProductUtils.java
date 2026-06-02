package com.javamarkt.cart.util;

import com.javamarkt.model.Product;

import java.util.Collection;

public class ProductUtils {

    // Suma cen po rabatach (discountPrice)
    public static double sumDiscountPrices(Collection<Product> products) {
        if (products == null) return 0.0;
        return products.stream()
                .mapToDouble(Product::getDiscountPrice)
                .sum();
    }

    // Suma cen bazowych (price)
    public static double sumPrices(Collection<Product> products) {
        if (products == null) return 0.0;
        return products.stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }
}
