error id: file:///C:/Users/weron/OneDrive/Dokumenty/java/zad3/src/main/java/com/javamarkt/cart/util/ProductComparators.java:_empty_/Product#
file:///C:/Users/weron/OneDrive/Dokumenty/java/zad3/src/main/java/com/javamarkt/cart/util/ProductComparators.java
empty definition using pc, found symbol in pc: _empty_/Product#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 265
uri: file:///C:/Users/weron/OneDrive/Dokumenty/java/zad3/src/main/java/com/javamarkt/cart/util/ProductComparators.java
text:
```scala
// ProductComparators.java

package com.javamarkt.cart.util;

import com.javamarkt.model.Product;
import java.util.Comparator;

public class ProductComparators {

    // Sortowanie malejąco po cenie, potem alfabetycznie
    public static final Comparator<@@Product> BY_PRICE_DESC_THEN_NAME_ASC =
            Comparator.comparingDouble(Product::getPrice).reversed()
                      .thenComparing(Product::getName);

    public static final Comparator<Product> BY_PRICE_ASC =
            Comparator.comparingDouble(Product::getPrice);

    public static final Comparator<Product> BY_PRICE_DESC =
            Comparator.comparingDouble(Product::getPrice).reversed();

    public static final Comparator<Product> BY_NAME_ASC =
            Comparator.comparing(Product::getName);
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: _empty_/Product#