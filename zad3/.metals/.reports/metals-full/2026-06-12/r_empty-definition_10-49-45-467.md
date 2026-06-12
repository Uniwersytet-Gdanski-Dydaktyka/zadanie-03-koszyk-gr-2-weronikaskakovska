error id: file:///C:/Users/weron/OneDrive/Dokumenty/java/zad3/src/main/java/com/javamarkt/cart/util/ShoppingCart.java:_empty_/Product#
file:///C:/Users/weron/OneDrive/Dokumenty/java/zad3/src/main/java/com/javamarkt/cart/util/ShoppingCart.java
empty definition using pc, found symbol in pc: _empty_/Product#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 769
uri: file:///C:/Users/weron/OneDrive/Dokumenty/java/zad3/src/main/java/com/javamarkt/cart/util/ShoppingCart.java
text:
```scala
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
        List<@@Product> current = new ArrayList<>(products);

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

```


#### Short summary: 

empty definition using pc, found symbol in pc: _empty_/Product#