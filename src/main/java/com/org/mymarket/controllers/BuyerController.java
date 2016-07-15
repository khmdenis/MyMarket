package com.org.mymarket.controllers;

import com.org.mymarket.model.Buyer;
import com.org.mymarket.model.Cart;
import com.org.mymarket.model.Deal;
import com.org.mymarket.services.interfaces.BuyerService;
import com.org.mymarket.services.interfaces.DealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Created by denis on 11.07.16.
 */
@Controller
@RequestMapping("/buyer_info")
public class BuyerController {
    @Autowired
    BuyerService buyerService;
    @Autowired
    DealService dealService;
    @Autowired
    Cart cart;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView setBuyer() {
        return new ModelAndView("buyer_info", "buyer", new Buyer());
    }


    @RequestMapping(method = RequestMethod.POST)
    public String checkout(@ModelAttribute("buyer") @Valid Buyer buyer, BindingResult result) {
        if (result.hasErrors()) {
            return "buyer_info";
        }
        buyerService.add(buyer);
        Deal deal = new Deal();
        deal.setBuyer(buyer);
        deal.setPurchases(cart);
        dealService.add(deal);
        cart.clear();
        return "redirect:/";
    }
}
