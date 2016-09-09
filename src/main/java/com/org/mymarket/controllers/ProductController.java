package com.org.mymarket.controllers;

import com.org.mymarket.model.Cart;
import com.org.mymarket.model.Category;
import com.org.mymarket.model.Image;
import com.org.mymarket.model.Product;
import com.org.mymarket.services.interfaces.CategoryService;
import com.org.mymarket.services.interfaces.ImageService;
import com.org.mymarket.services.interfaces.ProductService;
import com.org.mymarket.util.ImageBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private Cart cart;
    @Autowired
    private ImageService imageService;
    @Autowired
    private CategoryService categoryService;

    @ModelAttribute("categories")
    public List<Category> getCategories() {
        return categoryService.getList();
    }

    @ModelAttribute("cart")
    public Cart getCart() {
        return this.cart;
    }

    @RequestMapping("/")
    public String homePage() {
        return "redirect:/products/";
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public ModelAndView getProductList() {
        return new ModelAndView("products", "listProducts", productService.getList());
    }

    @RequestMapping(value = "/products/new")
    public ModelAndView addNewProduct() {
        return new ModelAndView("add_product", "product", new Product());
    }

    @RequestMapping(value = "/products/add", method = RequestMethod.POST)
    public String addOrUpdateProduct(@ModelAttribute("product") Product p,
                                     @RequestParam("upload") MultipartFile upload) throws Exception {

        if (p.getId() == null) productService.add(p);
        else {
            p.setImage(productService.getById(p.getId()).getImage());
            productService.update(p);
        }
        if (!upload.isEmpty()) {
            Image img = ImageBuilder.build(upload);
            imageService.add(img);
            p.setImage(img);
            productService.update(p);
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/products/remove/{id}", method = RequestMethod.GET)
    public String removeProduct(@PathVariable("id") Long id) {
        productService.remove(id);
        return "redirect:/";
    }

    @RequestMapping(value = "/products/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editProduct(@PathVariable("id") Long id) {
        return new ModelAndView("add_product", "product", productService.getById(id));
    }

    @RequestMapping(value = "/products/sort={type}", method = RequestMethod.GET)
    public ModelAndView getProductSortedList(@PathVariable("type") String type) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("product", new Product());
        modelAndView.addObject("listProducts", productService.getSortedProductListAscOrDesc(type));
        modelAndView.setViewName("products");
        return modelAndView;
    }

    @RequestMapping("/products/{category}")
    public ModelAndView getProductListByCategory(@PathVariable("category") String name) {
        ModelAndView modelAndView = new ModelAndView();
        Category category = categoryService.getByName(name);
        modelAndView.addObject("listProducts", productService.getListByCategory(category));
        modelAndView.setViewName("products");
        return modelAndView;
    }


}


