package com.org.mymarket.model;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by denis on 09.07.16.
 */
@Component
public class Cart extends HashMap<Product, Integer> {

    private double totalPrice = 0;

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void adjustTotalPrice(Double d) {
        totalPrice += d;
    }


    @Override
    public void clear() {
        super.clear();
        totalPrice = 0;
    }

    public Set<CartItem> convertToCartItemSet() {
        Set<CartItem> set = new HashSet<>();
        for (Map.Entry entry : this.entrySet()) {
            set.add(new CartItem((Product) entry.getKey(), (Integer) entry.getValue()));
        }
        return set;
    }

    public Integer getTotalQuantity() {
        Integer quantity = 0;
        for (Integer value : this.values())
            quantity += value;
        return quantity;
    }
}
