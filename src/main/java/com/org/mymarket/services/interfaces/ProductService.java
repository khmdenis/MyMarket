package com.org.mymarket.services.interfaces;

import com.org.mymarket.model.Product;

import java.util.List;

/**
 * Created by denis on 02.07.16.
 */
public interface ProductService extends BaseService<Product> {
    List<Product> getSortedProductListASC(String type);

    List<Product> getSortedProductListDESC(String type);
}
