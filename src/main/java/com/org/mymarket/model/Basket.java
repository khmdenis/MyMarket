package com.org.mymarket.model;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by denis on 09.07.16.
 */
@Component
public class Basket {
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

    public void clearBasket() {
        basket.clear();
    }

}
