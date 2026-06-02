package com.javamarkt.util;


public final class ProductUtils {

    private ProductUtils() {}

    public static Optional<Product> findCheapest(List<Product> products) {
        return safeStream(products)
                .min(Comparator.comparingDouble(Product::getDiscountPrice));
    }

    public static Optional<Product> findMostExpensive(List<Product> products) {
        return safeStream(products)
                .max(Comparator.comparingDouble(Product::getDiscountPrice));
    }

    public static List<Product> findNCheapest(List<Product> products, int n) {
        return safeStream(products)
                .sorted(Comparator.comparingDouble(Product::getDiscountPrice))
                .limit(n)
                .toList();
    }

    public static List<Product> findNMostExpensive(List<Product> products, int n) {
        return safeStream(products)
                .sorted(Comparator.comparingDouble(Product::getDiscountPrice).reversed())
                .limit(n)
                .toList();
    }

    public static List<Product> sortByPriceDescThenNameAsc(List<Product> products) {
        return safeStream(products)
                .sorted(
                        Comparator.comparingDouble(Product::getDiscountPrice).reversed()
                                .thenComparing(Product::getName)
                )
                .toList();
    }

    public static double sumDiscountPrices(List<Product> products) {
        return safeStream(products)
                .mapToDouble(Product::getDiscountPrice)
                .sum();
    }

    private static Stream<Product> safeStream(List<Product> products) {
        if (products == null || products.isEmpty()) return Stream.empty();
        return products.stream().filter(Objects::nonNull);
    }
}
