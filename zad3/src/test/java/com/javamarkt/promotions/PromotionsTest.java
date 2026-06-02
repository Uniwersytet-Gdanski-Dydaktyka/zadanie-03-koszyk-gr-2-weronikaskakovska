package com.javamarkt.promotions;

import com.javamarkt.model.Product;
import com.javamarkt.util.ProductUtils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class PromotionsTest {

    @Test
    void testOrderValueDiscount() {
        Product p1 = new Product("A", "A", 200);
        Product p2 = new Product("B", "B", 150);

        var promo = new OrderValuePercentageDiscountPromotion(300, 0.05);
        var result = promo.apply(List.of(p1, p2));

        double expected = (200 + 150) * 0.95;
        assertEquals(expected, ProductUtils.sumDiscountPrices(result), 0.0001);
    }

    @Test
    void testThreeForTwo() {
        Product p1 = new Product("A", "A", 100);
        Product p2 = new Product("B", "B", 50);
        Product p3 = new Product("C", "C", 200);

        var promo = new ThreeForTwoCheapestFreePromotion();
        var result = promo.apply(List.of(p1, p2, p3));

        assertEquals(0.0, ProductUtils.findCheapest(result).get().getDiscountPrice());
    }

    @Test
    void testFreeMug() {
        Product p1 = new Product("A", "A", 250);
        Product mug = new Product("MUG", "Kubek", 30);

        var promo = new FreeMugPromotion(200, mug);
        var result = promo.apply(List.of(p1));

        assertEquals(2, result.size());
        assertTrue(result.stream().anyMatch(p -> p.getCode().equals("MUG")));
    }

    @Test
    void testCoupon() {
        Product p1 = new Product("A", "A", 100);

        var promo = new SingleProductCouponPromotion("A", 0.30);
        var result = promo.apply(List.of(p1));

        assertEquals(70.0, result.get(0).getDiscountPrice(), 0.0001);
    }
}