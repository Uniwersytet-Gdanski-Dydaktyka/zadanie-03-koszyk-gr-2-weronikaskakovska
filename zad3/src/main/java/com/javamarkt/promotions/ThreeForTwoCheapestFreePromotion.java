// ThreeForTwoCheapestFreePromotion.java
// Promocja: na każde 3 produkty najtańszy jest za darmo.

package com.javamarkt.promotions;

import com.javamarkt.cart.util.ProductComparators;
import com.javamarkt.model.Product;
import java.util.ArrayList;
import java.util.List;

public class ThreeForTwoCheapestFreePromotion implements Promotion {

    @Override
    public List<Product> apply(List<Product> products) {
        List<Product> sorted = new ArrayList<>(products);
        sorted.sort(ProductComparators.BY_PRICE_ASC); // najtańsze pierwsze

        List<Product> result = new ArrayList<>();

        for (int i = 0; i < sorted.size(); i += 3) {
            int end = Math.min(i + 3, sorted.size());
            List<Product> group = sorted.subList(i, end);

            if (group.size() < 3) {
                result.addAll(group);
            } else {
                // najtańszy gratis
                Product cheapest = group.get(0);
                result.add(cheapest.withDiscountPrice(0.0));

                // pozostałe bez zmian
                result.add(group.get(1));
                result.add(group.get(2));
            }
        }
        return result;
    }

    @Override
    public String getName() {
        return "ThreeForTwo";
    }
}
