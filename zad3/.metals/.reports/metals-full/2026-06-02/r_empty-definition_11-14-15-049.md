error id: file:///C:/Users/weron/OneDrive/Dokumenty/java/zad3/src/test/java/com/javamarkt/util/ProductUtilsTest.java:_empty_/Product#
file:///C:/Users/weron/OneDrive/Dokumenty/java/zad3/src/test/java/com/javamarkt/util/ProductUtilsTest.java
empty definition using pc, found symbol in pc: _empty_/Product#
found definition using semanticdb; symbol com/javamarkt/util/ProductUtilsTest#testFindCheapest().
empty definition using fallback
non-local guesses:

offset: 332
uri: file:///C:/Users/weron/OneDrive/Dokumenty/java/zad3/src/test/java/com/javamarkt/util/ProductUtilsTest.java
text:
```scala
package com.javamarkt.util;

import com.javamarkt.cart.util.ProductUtils;
import com.javamarkt.model.Product;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class ProductUtilsTest {

    @Test
    public void testFindCheapest() {
        List<Produc@@t> products = List.of(
                new Product("A", "A", 10),
                new Product("B", "B", 5),
                new Product("C", "C", 20)
        );

        Product cheapest = ProductUtils.findCheapest(products).orElseThrow();
        assertEquals(5.0, cheapest.getPrice(), 0.001);
    }

    @Test
    public void testFindMostExpensive() {
        List<Product> products = List.of(
                new Product("A", "A", 10),
                new Product("B", "B", 5),
                new Product("C", "C", 20)
        );

        Product mostExpensive = ProductUtils.findMostExpensive(products).orElseThrow();
        assertEquals(20.0, mostExpensive.getPrice(), 0.001);
    }

    @Test
    public void testSumPrices() {
        List<Product> products = List.of(
                new Product("A", "A", 10),
                new Product("B", "B", 5)
        );

        assertEquals(15.0, ProductUtils.sumPrices(products), 0.001);
    }
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: _empty_/Product#