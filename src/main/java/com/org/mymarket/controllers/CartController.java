package com.org.mymarket.controllers;

import com.org.mymarket.model.Cart;
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
public class CartController {
    @Autowired
    private Cart cart;
    @Autowired
    ProductService productService;

    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public ModelAndView listProducts() {
        return new ModelAndView("cart", "cart", cart);
    }

    @RequestMapping(value = "/cart/put/{id}", method = RequestMethod.GET)
    public String putInCart(@PathVariable("id") Long id) {
        Product p = productService.getById(id);
        if (cart.containsKey(p)) {
            cart.put(p, cart.get(p) + 1);
        } else cart.put(p, 1);
        cart.adjustSum(p.getPrice());
        return "redirect:/";
    }

    @RequestMapping(value = "/cart/remove/{id}", method = RequestMethod.GET)
    public String removeFromCart(@PathVariable("id") Long id) {
        Product p = productService.getById(id);
        cart.adjustSum(-p.getPrice() * cart.get(p));
        cart.remove(p);
        return "redirect:/cart";
    }

    @RequestMapping(value = "/cart/clean", method = RequestMethod.GET)
    public String cleanCart() {
        cart.clear();
        return "redirect:/cart";
    }

}
