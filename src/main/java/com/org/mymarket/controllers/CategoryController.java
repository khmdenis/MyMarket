package com.org.mymarket.controllers;

import com.org.mymarket.model.Category;
import com.org.mymarket.services.interfaces.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/category")
    public ModelAndView getCategoryList() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("category");
        modelAndView.addObject("category", new Category());
        modelAndView.addObject("categories", categoryService.getList());
        return modelAndView;
    }

    @RequestMapping("/category/add")
    public String addCategory(@ModelAttribute("category") Category category) {
        categoryService.add(category);
        return "redirect:/category";
    }

}
