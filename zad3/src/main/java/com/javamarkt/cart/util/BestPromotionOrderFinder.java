package com.javamarkt.cart.util;

import com.javamarkt.model.Product;
import com.javamarkt.promotions.Promotion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BestPromotionOrderFinder {

    // Zwraca listę produktów po zastosowaniu najlepszej kolejności promocji
    public static List<Product> findBestOrder(List<Product> products, List<Promotion> promotions) {
        if (products == null || products.isEmpty() || promotions == null || promotions.isEmpty()) {
            return new ArrayList<>(products);
        }

        double bestTotal = Double.MAX_VALUE;
        List<Product> bestProducts = null;

        List<List<Promotion>> perms = permutations(promotions);
        for (List<Promotion> order : perms) {
            List<Product> current = new ArrayList<>(products);
            for (Promotion p : order) {
                current = p.apply(current);
            }
            double total = ProductUtils.sumDiscountPrices(current);
            if (total < bestTotal) {
                bestTotal = total;
                bestProducts = current;
            }
        }
        return bestProducts != null ? bestProducts : new ArrayList<>(products);
    }

    private static List<List<Promotion>> permutations(List<Promotion> list) {
        List<List<Promotion>> result = new ArrayList<>();
        permute(list, 0, result);
        return result;
    }

    private static void permute(List<Promotion> arr, int k, List<List<Promotion>> result) {
        if (k == arr.size()) {
            result.add(new ArrayList<>(arr));
        } else {
            for (int i = k; i < arr.size(); i++) {
                Collections.swap(arr, i, k);
                permute(arr, k + 1, result);
                Collections.swap(arr, i, k);
            }
        }
    }
}
