// Promotion.java
// Interfejs strategii — każda promocja implementuje tę samą metodę apply().
// Dzięki temu mogę dodawać nowe promocje bez zmieniania starego kodu (Open/Closed Principle).

package com.javamarkt.promotions;

import com.javamarkt.model.Product;
import java.util.List;

public interface Promotion {

    // Zwraca NOWĄ listę produktów z uwzględnionymi rabatami
    List<Product> apply(List<Product> products);

    // Nazwa promocji — przydatne do debugowania i testów
    String getName();
}
