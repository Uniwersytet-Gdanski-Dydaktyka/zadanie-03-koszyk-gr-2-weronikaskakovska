package com.javamarkt.cart.util;

import com.javamarkt.model.Product;
import com.javamarkt.promotions.Promotion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShoppingCart {

    private final List<Product> products = new ArrayList<>();
    private final List<Promotion> promotions = new ArrayList<>();

    // Dodawanie produktu
    public void addProduct(Product product) {
        if (product != null) products.add(product);
    }

    // Dodawanie promocji
    public void addPromotion(Promotion promotion) {
        if (promotion != null) promotions.add(promotion);
    }

    // Zastosowanie promocji w kolejności dodania
    public List<Product> applyPromotionsInOrder() {
        List<Product> current = new ArrayList<>(products);

        for (Promotion p : promotions) {
            current = p.apply(current);
        }
        return current;
    }

    // Najlepsza kolejność promocji
    public List<Product> applyBestPromotionOrderForCustomer() {
        return BestPromotionOrderFinder.findBestOrder(products, promotions);
    }

    // Zwraca produkty bez możliwości modyfikacji
    public List<Product> getProducts() {
        return Collections.unmodifiableList(products);
    }
}
