package com.javamarkt;

import com.javamarkt.model.Product;
import com.javamarkt.cart.ShoppingCart;
import com.javamarkt.promotions.*;
import com.javamarkt.util.ProductUtils;

import java.util.List;


public class Main {
    public static void main(String[] args) {

        Product p1 = new Product("P1", "Klawiatura", 150);
        Product p2 = new Product("P2", "Mysz", 80);
        Product p3 = new Product("P3", "Monitor", 400);

        Product mug = new Product("MUG", "Kubek JavaMarkt", 30);

        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(p1);
        cart.addProduct(p2);
        cart.addProduct(p3);

        cart.addPromotion(new OrderValuePercentageDiscountPromotion(300, 0.05));
        cart.addPromotion(new ThreeForTwoCheapestFreePromotion());
        cart.addPromotion(new FreeMugPromotion(200, mug));
        cart.addPromotion(new SingleProductCouponPromotion("P3", 0.30));

        var best = cart.applyBestPromotionOrderForCustomer();
        System.out.println("Najlepsza suma: " + ProductUtils.sumDiscountPrices(best));
    }
}
