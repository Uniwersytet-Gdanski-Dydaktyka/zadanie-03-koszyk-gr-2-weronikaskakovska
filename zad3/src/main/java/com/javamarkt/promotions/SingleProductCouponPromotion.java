// SingleProductCouponPromotion.java
// Obniża cenę tylko jednego produktu o podany procent.

package com.javamarkt.promotions;

import com.javamarkt.model.Product;
import java.util.ArrayList;
import java.util.List;

public class SingleProductCouponPromotion implements Promotion {

    private final String productCode;
    private final double percentage;

    public SingleProductCouponPromotion(String productCode, double percentage) {
        this.productCode = productCode;
        this.percentage = percentage;
    }

    @Override
    public List<Product> apply(List<Product> products) {
        List<Product> result = new ArrayList<>();

        for (Product p : products) {
            if (p.getCode().equals(productCode)) {
                double newPrice = p.getDiscountPrice() * (1 - percentage);
                result.add(p.withDiscountPrice(newPrice));
            } else {
                result.add(p);
            }
        }
        return result;
    }

    @Override
    public String getName() {
        return "SingleProductCoupon";
    }
}
