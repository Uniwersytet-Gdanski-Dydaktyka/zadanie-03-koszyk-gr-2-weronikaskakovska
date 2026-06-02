// Product.java
// Ta klasa reprezentuje pojedynczy produkt w sklepie.
// Jest IMMUTABLE — czyli po stworzeniu obiektu nie można go zmienić.
// To jest bardzo dobre dla promocji, bo nie psujemy oryginalnych danych.

package com.javamarkt.model;

public final class Product {

    private final String code;          // unikalny kod produktu
    private final String name;          // nazwa produktu
    private final double price;         // cena podstawowa
    private final double discountPrice; // cena po rabacie (domyślnie = price)

    // Konstruktor podstawowy — produkt bez rabatu
    public Product(String code, String name, double price) {
        this(code, name, price, price);
    }

    // Konstruktor pełny — używany gdy promocja zmienia cenę
    public Product(String code, String name, double price, double discountPrice) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.discountPrice = discountPrice;
    }

    // Gettery — tylko do odczytu
    public String getCode() { return code; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public double getDiscountPrice() { return discountPrice; }

    // Tworzy NOWY produkt z inną ceną po rabacie
    // To jest kluczowe dla immutability
    public Product withDiscountPrice(double newPrice) {
        return new Product(code, name, price, newPrice);
    }
}
