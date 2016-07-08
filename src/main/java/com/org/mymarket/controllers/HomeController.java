package com.org.mymarket.controllers;

import com.org.mymarket.model.Product;
import com.org.mymarket.services.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {
    @Autowired
    ProductService productService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getProductList(Model model){
        model.addAttribute("product", new Product());
        model.addAttribute("listProducts", productService.getList());
        return "products";
    }
    @RequestMapping(value="/products/add", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("product") Product p){
       if(p.getId() == null) {
           productService.add(p);
       }
        else {
           productService.update(p);
       }
        return "redirect:/";
    }
    @RequestMapping(value = "/products/remove/{id}", method = RequestMethod.GET)
    public String removeProduct(@ModelAttribute("product") Product p){
        productService.remove(p);
        return "redirect:/";
    }
    @RequestMapping("/products/edit/{id}")
    public String editProduct(@PathVariable("id") Long id, Model model){
        model.addAttribute("product", productService.getById(id));
        model.addAttribute("listProducts", productService.getList());
        return "products";
    }

}


