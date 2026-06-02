// OrderValuePercentageDiscountPromotion.java
// Promocja: jeśli suma koszyka > threshold, obniż wszystkie ceny o percentage.

package com.javamarkt.promotions;

import com.javamarkt.cart.util.ProductUtils;
import com.javamarkt.model.Product;
import java.util.ArrayList;
import java.util.List;

public class OrderValuePercentageDiscountPromotion implements Promotion {

    private final double threshold;  // próg np. 300 zł
    private final double percentage; // np. 0.05 = 5%

    public OrderValuePercentageDiscountPromotion(double threshold, double percentage) {
        this.threshold = threshold;
        this.percentage = percentage;
    }

    @Override
    public List<Product> apply(List<Product> products) {
        double sum = ProductUtils.sumPrices(products);

        // Jeśli nie przekracza progu — nic nie robimy
        if (sum <= threshold) return new ArrayList<>(products);

        // Tworzymy nową listę z obniżonymi cenami
        List<Product> result = new ArrayList<>();
        for (Product p : products) {
            double newPrice = p.getDiscountPrice() * (1 - percentage);
            result.add(p.withDiscountPrice(newPrice));
        }
        return result;
    }

    @Override
    public String getName() {
        return "OrderValuePercentageDiscount";
    }
}
