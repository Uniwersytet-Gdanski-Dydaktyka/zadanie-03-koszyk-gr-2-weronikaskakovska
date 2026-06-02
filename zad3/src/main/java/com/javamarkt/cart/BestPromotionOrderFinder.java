package com.javamarkt.cart;

import com.javamarkt.model.Product;
import com.javamarkt.promotions.Promotion;
import com.javamarkt.util.ProductUtils;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


public class BestPromotionOrderFinder {

    public List<Product> findBest(List<Product> originalProducts, List<Promotion> promotions) {
        if (originalProducts.isEmpty() || promotions.isEmpty()) return originalProducts;

        List<Promotion> bestOrder = null;
        double bestTotal = Double.MAX_VALUE;
        List<Product> bestProducts = null;

        for (List<Promotion> perm : permutations(promotions)) {
            List<Product> current = new ArrayList<>(originalProducts);
            for (Promotion p : perm) {
                current = p.apply(current);
            }
            double total = ProductUtils.sumDiscountPrices(current);
            if (total < bestTotal) {
                bestTotal = total;
                bestProducts = current;
            }
        }
        return bestProducts;
    }

    private List<List<Promotion>> permutations(List<Promotion> list) {
        List<List<Promotion>> result = new ArrayList<>();
        permute(list, 0, result);
        return result;
    }

    private void permute(List<Promotion> list, int start, List<List<Promotion>> result) {
        if (start == list.size() - 1) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < list.size(); i++) {
            Collections.swap(list, start, i);
            permute(list, start + 1, result);
            Collections.swap(list, start, i);
        }
    }
}
