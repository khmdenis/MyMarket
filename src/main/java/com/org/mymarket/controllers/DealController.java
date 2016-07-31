package com.org.mymarket.controllers;

import com.org.mymarket.services.interfaces.DealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by denis on 15.07.16.
 */
@Controller
public class DealController {
    @Autowired
    DealService dealService;

    @RequestMapping(value = "/deals", method = RequestMethod.GET)
    public ModelAndView getDealsList() {

        return new ModelAndView("deals", "deals", dealService.getList());
    }
}
