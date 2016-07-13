package com.org.mymarket.controllers;

import com.org.mymarket.model.Cart;
import com.org.mymarket.model.Product;
import com.org.mymarket.services.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private Cart cart;
    private String order = "";


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getProductList() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("products");
        modelAndView.addObject("product", new Product());
        modelAndView.addObject("cart", cart);
        modelAndView.addObject("listProducts", productService.getList());
        return modelAndView;
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
    public ModelAndView editProduct(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("product", productService.getById(id));
        modelAndView.addObject("listProducts", productService.getList());
        modelAndView.setViewName("products");
        return modelAndView;
    }

    @RequestMapping(value = "/products/sort={type}", method = RequestMethod.GET)
    public ModelAndView getProductSortedList(@PathVariable("type") String type) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("product", new Product());
        if (order.equals("") || order.equals("asc")) {
            modelAndView.addObject("listProducts", productService.getSortedProductListASC(type));
            order = "desc";
        } else if (order.equals("desc")) {
            modelAndView.addObject("listProducts", productService.getSortedProductListDESC(type));
            order = "asc";
        } else {
            modelAndView.addObject("listProducts", productService.getList());
        }
        modelAndView.addObject("order", order);
        modelAndView.setViewName("products");
        return modelAndView;
    }


}


