// ProductComparators.java
// Zbiór gotowych komparatorów do sortowania produktów.
// Dzięki temu sortowanie jest elastyczne i zgodne z DIP.

package com.javamarkt.cart.util;

import com.javamarkt.model.Product;
import java.util.Comparator;

public class ProductComparators {

    // Sortowanie malejąco po cenie, potem alfabetycznie
    public static final Comparator<Product> BY_PRICE_DESC_THEN_NAME_ASC =
            Comparator.comparingDouble(Product::getPrice).reversed()
                      .thenComparing(Product::getName);

    public static final Comparator<Product> BY_PRICE_ASC =
            Comparator.comparingDouble(Product::getPrice);

    public static final Comparator<Product> BY_PRICE_DESC =
            Comparator.comparingDouble(Product::getPrice).reversed();

    public static final Comparator<Product> BY_NAME_ASC =
            Comparator.comparing(Product::getName);
}
