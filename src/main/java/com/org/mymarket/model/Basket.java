package com.org.mymarket.model;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by denis on 09.07.16.
 */
@Component
public class Basket {
    private double sum = 0;

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    private Map<Product, Integer> basket = new HashMap();

    public Map<Product, Integer> getBasket() {
        return basket;
    }

    public void addProduct(Product product, Integer amount) {
        basket.put(product, amount);
    }

    public void removeProduct(Product product) {
        basket.remove(product);
    }

    public void adjustSum(Double d) {
        sum += d;
    }
    public void clearBasket() {
        basket.clear();
    }

}
