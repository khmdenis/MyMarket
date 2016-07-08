package com.org.mymarket.dao.interfaces;

import com.org.mymarket.model.Product;

import java.util.List;

/**
 * Created by denis on 02.07.16.
 */
public interface ProductDAO extends BaseDAO<Product> {
    List<Product> getSortedListASC(String type);

    List<Product> getSortedListDESC(String type);
}
