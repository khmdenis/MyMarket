package com.org.mymarket.controllers;

import com.org.mymarket.model.Deal;
import com.org.mymarket.services.interfaces.DealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by denis on 15.07.16.
 */
@Controller
public class DealController {
    @Autowired
    DealService dealService;

    @RequestMapping(value = "/deals", method = RequestMethod.GET)
    public ModelAndView getDealsList() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("deals");
        List<Deal> list = dealService.getList();
        for (Deal deal : list) {
            System.out.println(deal.getPurchases());
        }
        modelAndView.addObject("deals", list);
        return modelAndView;
        //return new ModelAndView("deals","deals", dealService.getList());}
    }
}
