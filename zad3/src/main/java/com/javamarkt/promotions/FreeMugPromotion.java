// FreeMugPromotion.java
// Jeśli suma koszyka > threshold, dodajemy produkt "kubek" o cenie 0.

package com.javamarkt.promotions;

import com.javamarkt.cart.util.ProductUtils;
import com.javamarkt.model.Product;
import java.util.ArrayList;
import java.util.List;

public class FreeMugPromotion implements Promotion {

    private final double threshold;
    private final Product mug;

    public FreeMugPromotion(double threshold, Product mug) {
        this.threshold = threshold;
        this.mug = mug;
    }

    @Override
    public List<Product> apply(List<Product> products) {
        double sum = ProductUtils.sumPrices(products);
        List<Product> result = new ArrayList<>(products);

        if (sum > threshold) {
            result.add(mug); // kubek gratis
        }
        return result;
    }

    @Override
    public String getName() {
        return "FreeMug";
    }
}
