package com.javamarkt.promotions;

import com.javamarkt.model.Product;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

public class FreeMugPromotion implements Promotion {

    private final double threshold;
    private final Product mugProduct;

    public FreeMugPromotion(double threshold, Product mugProduct) {
        this.threshold = threshold;
        this.mugProduct = mugProduct;
    }

    @Override
    public List<Product> apply(List<Product> products) {
        if (products == null || products.isEmpty()) return List.of();

        double sum = products.stream()
                .mapToDouble(Product::getDiscountPrice)
                .sum();

        if (sum <= threshold) return products;

        List<Product> result = new ArrayList<>(products);
        result.add(mugProduct.withDiscountPrice(0.0));
        return result;
    }
}
