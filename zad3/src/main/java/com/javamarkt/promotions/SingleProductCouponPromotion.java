package com.javamarkt.promotions;

import com.javamarkt.model.Product;
import java.util.List;
import java.util.ArrayList;


public class SingleProductCouponPromotion implements Promotion {

    private final String productCode;
    private final double percentage;

    public SingleProductCouponPromotion(String productCode, double percentage) {
        this.productCode = productCode;
        this.percentage = percentage;
    }

    @Override
    public List<Product> apply(List<Product> products) {
        if (products == null || products.isEmpty()) return List.of();

        List<Product> result = new ArrayList<>();
        boolean used = false;

        for (Product p : products) {
            if (!used && p.getCode().equals(productCode)) {
                result.add(p.withDiscountPrice(p.getDiscountPrice() * (1 - percentage)));
                used = true;
            } else {
                result.add(p);
            }
        }
        return result;
    }
}
