package com.javamarkt.util;

import com.javamarkt.model.Product;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class ProductUtilsTest {

    @Test
    void testFindCheapest() {
        var p1 = new Product("A", "A", 100);
        var p2 = new Product("B", "B", 50);

        var cheapest = ProductUtils.findCheapest(List.of(p1, p2));

        assertEquals("B", cheapest.get().getCode());
    }

    @Test
    void testFindMostExpensive() {
        var p1 = new Product("A", "A", 100);
        var p2 = new Product("B", "B", 50);

        var mostExpensive = ProductUtils.findMostExpensive(List.of(p1, p2));

        assertEquals("A", mostExpensive.get().getCode());
    }

    @Test
    void testSum() {
        var p1 = new Product("A", "A", 100);
        var p2 = new Product("B", "B", 50);

        double sum = ProductUtils.sumDiscountPrices(List.of(p1, p2));

        assertEquals(150.0, sum, 0.0001);
    }
}
