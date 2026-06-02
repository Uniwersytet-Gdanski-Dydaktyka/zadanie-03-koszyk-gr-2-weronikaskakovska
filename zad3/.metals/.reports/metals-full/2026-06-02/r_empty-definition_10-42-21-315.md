error id: file:///C:/Users/weron/OneDrive/Dokumenty/java/zad3/src/main/java/com/javamarkt/cart/ShoppingCart.java:_empty_/Promotion#
file:///C:/Users/weron/OneDrive/Dokumenty/java/zad3/src/main/java/com/javamarkt/cart/ShoppingCart.java
empty definition using pc, found symbol in pc: _empty_/Promotion#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 943
uri: file:///C:/Users/weron/OneDrive/Dokumenty/java/zad3/src/main/java/com/javamarkt/cart/ShoppingCart.java
text:
```scala
// ShoppingCart.java
// Przechowuje produkty i pozwala stosować promocje w dowolnej kolejności.

package com.javamarkt.cart.util;

import com.javamarkt.model.Product;
import com.javamarkt.promotions.Promotion;
import java.util.*;

public class ShoppingCart {

    private final List<Product> products = new ArrayList<>();

    // Dodawanie produktu
    public void addProduct(Product product) {
        if (product != null) products.add(product);
    }

    // Zwraca niemodyfikowalną listę
    public List<Product> getProducts() {
        return Collections.unmodifiableList(products);
    }

    // Suma po rabatach
    public double getTotalPrice() {
        return ProductUtils.sumPrices(products);
    }

    // Zastosowanie promocji w podanej kolejności
    public List<Product> applyPromotions(List<Promotion> promotions) {
        List<Product> current = new ArrayList<>(products);

        for (Promoti@@on p : promotions) {
            current = p.apply(current);
        }
        return current;
    }
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: _empty_/Promotion#