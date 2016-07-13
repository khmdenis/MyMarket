package com.org.mymarket.controllers;

import com.org.mymarket.model.Buyer;
import com.org.mymarket.model.Cart;
import com.org.mymarket.model.Deal;
import com.org.mymarket.services.interfaces.BuyerService;
import com.org.mymarket.services.interfaces.DealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by denis on 11.07.16.
 */
@Controller
public class DealController {
    @Autowired
    BuyerService buyerService;
    @Autowired
    DealService dealService;
    @Autowired
    Cart cart;

    @RequestMapping(value = "/buyer_info", method = RequestMethod.GET)
    public ModelAndView identify() {
        return new ModelAndView("buyer_info", "buyer", new Buyer());
    }

    @RequestMapping(value = "/buyer_info/checkout", method = RequestMethod.POST)

    public String checkout(@ModelAttribute("buyer") Buyer buyer) {
        buyer.setPurchase(1);
        buyerService.add(buyer);
        Deal deal = new Deal();
        deal.setBuyer(buyer);
        deal.setPurchases(cart);
        dealService.add(deal);
        return "redirect:/";
    }
}
