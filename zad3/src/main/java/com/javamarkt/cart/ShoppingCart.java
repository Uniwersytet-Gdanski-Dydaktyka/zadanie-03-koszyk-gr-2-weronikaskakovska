package com.javamarkt.cart;

import com.javamarkt.model.Product;
import com.javamarkt.promotions.Promotion;
import java.util.List;
import java.util.ArrayList;

public class ShoppingCart {

    private final List<Product> products = new ArrayList<>();
    private final List<Promotion> promotions = new ArrayList<>();

    public void addProduct(Product product) {
        if (product != null) products.add(product);
    }

    public void addPromotion(Promotion promotion) {
        if (promotion != null) promotions.add(promotion);
    }

    public List<Product> applyPromotionsInOrder() {
        List<Product> current = new ArrayList<>(products);
        for (Promotion p : promotions) {
            current = p.apply(current);
        }
        return current;
    }

    public List<Product> applyBestPromotionOrderForCustomer() {
        BestPromotionOrderFinder finder = new BestPromotionOrderFinder();
        return finder.findBest(products, promotions);
    }
}
