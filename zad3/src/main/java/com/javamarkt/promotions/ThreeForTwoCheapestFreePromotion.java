package com.javamarkt.promotions;

import com.javamarkt.model.Product;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;
import java.util.stream.Collectors;


public class ThreeForTwoCheapestFreePromotion implements Promotion {

    @Override
    public List<Product> apply(List<Product> products) {
        if (products == null || products.isEmpty()) return List.of();

        List<Product> nonNull = products.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        if (nonNull.size() < 3) return nonNull;

        List<Product> sorted = new ArrayList<>(nonNull);
        sorted.sort(Comparator.comparingDouble(Product::getDiscountPrice));

        Product cheapest = sorted.get(0);
        List<Product> result = new ArrayList<>();
        boolean freeApplied = false;

        for (Product p : nonNull) {
            if (!freeApplied && p.equals(cheapest)) {
                result.add(p.withDiscountPrice(0.0));
                freeApplied = true;
            } else {
                result.add(p);
            }
        }
        return result;
    }
}
