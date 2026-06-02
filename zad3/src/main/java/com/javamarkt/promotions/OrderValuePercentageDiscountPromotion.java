package com.javamarkt.promotions;

import com.javamarkt.model.Product;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class OrderValuePercentageDiscountPromotion implements Promotion {

    private final double threshold;
    private final double percentage;

    public OrderValuePercentageDiscountPromotion(double threshold, double percentage) {
        this.threshold = threshold;
        this.percentage = percentage;
    }

    @Override
    public List<Product> apply(List<Product> products) {
        if (products == null || products.isEmpty()) return List.of();

        double sum = products.stream()
                .filter(Objects::nonNull)
                .mapToDouble(Product::getDiscountPrice)
                .sum();

        if (sum <= threshold) return products;

        return products.stream()
                .map(p -> p.withDiscountPrice(p.getDiscountPrice() * (1 - percentage)))
                .collect(Collectors.toList());
    }
}
