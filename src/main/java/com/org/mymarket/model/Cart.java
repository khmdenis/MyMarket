package com.org.mymarket.model;

import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * Created by denis on 09.07.16.
 */
@Component
public class Cart extends HashMap<Product, Integer> {

    private double sum = 0;

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public void adjustSum(Double d) {
        sum += d;
    }

    public Integer getAmount() {
        Integer amount = 0;
        for (int v : this.values()) amount += v;
        return amount;
    }

}
