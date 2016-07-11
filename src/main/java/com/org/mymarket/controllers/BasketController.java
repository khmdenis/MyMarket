package com.org.mymarket.controllers;

import com.org.mymarket.model.Basket;
import com.org.mymarket.model.Product;
import com.org.mymarket.services.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by denis on 09.07.16.
 */
@Controller
public class BasketController {
    @Autowired
    private Basket basket;
    @Autowired
    ProductService productService;

    @RequestMapping(value = "/basket", method = RequestMethod.GET)
    public ModelAndView listProducts() {
        return new ModelAndView("basket", "basket", basket);
    }

    @RequestMapping(value = "/basket/put/{id}", method = RequestMethod.GET)
    public String putInBasket(@PathVariable("id") Long id) {
        Product p = productService.getById(id);
        if (basket.getBasket().containsKey(p)) {
            basket.addProduct(p, basket.getBasket().get(p) + 1);
        } else basket.addProduct(p, 1);
        basket.adjustSum(p.getPrice());
        return "redirect:/";
    }

    @RequestMapping(value = "/basket/remove/{id}", method = RequestMethod.GET)
    public String removeFromBasket(@PathVariable("id") Long id) {
        Product p = productService.getById(id);
        basket.adjustSum(-p.getPrice());
        basket.removeProduct(p);
        return "redirect:/basket";
    }


}
