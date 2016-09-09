package com.org.mymarket.services.interfaces;

import com.org.mymarket.model.Category;
import com.org.mymarket.model.Product;

import java.util.List;

/**
 * Created by denis on 02.07.16.
 */
public interface ProductService extends BaseService<Product> {
    void remove(Long id);

    List<Product> getSortedProductListAscOrDesc(String type);


    List<Product> getListByCategory(Category category);
}
