package com.javamarkt.promotions;

import com.javamarkt.model.Product;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PromotionsTest {

    @Test
    void testOrderValuePercentageDiscount() {
        List<Product> products = List.of(
                new Product("A", "A", 200),
                new Product("B", "B", 200)
        );

        Promotion promo = new OrderValuePercentageDiscountPromotion(300, 0.05);
        List<Product> result = promo.apply(products);

        assertEquals(190.0, result.get(0).getDiscountPrice(), 0.001);
        assertEquals(190.0, result.get(1).getDiscountPrice(), 0.001);
    }

    @Test
    void testThreeForTwo() {
        List<Product> products = List.of(
                new Product("A", "A", 10),
                new Product("B", "B", 20),
                new Product("C", "C", 30)
        );

        Promotion promo = new ThreeForTwoCheapestFreePromotion();
        List<Product> result = promo.apply(products);

        assertEquals(0.0, result.get(0).getDiscountPrice(), 0.001);
    }

    @Test
    void testFreeMug() {
        List<Product> products = List.of(
                new Product("A", "A", 150),
                new Product("B", "B", 100)
        );

        Product mug = new Product("MUG", "Kubek JavaMarkt", 0);
        Promotion promo = new FreeMugPromotion(200, mug);

        List<Product> result = promo.apply(products);

        assertEquals(3, result.size());
    }

    @Test
    void testSingleProductCoupon() {
        List<Product> products = List.of(
                new Product("A", "A", 100),
                new Product("B", "B", 50)
        );

        Promotion promo = new SingleProductCouponPromotion("A", 0.30);
        List<Product> result = promo.apply(products);

        assertEquals(70.0, result.get(0).getDiscountPrice(), 0.001);
        assertEquals(50.0, result.get(1).getDiscountPrice(), 0.001);
    }
}
