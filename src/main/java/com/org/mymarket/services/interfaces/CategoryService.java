package com.org.mymarket.services.interfaces;

import com.org.mymarket.model.Category;

/**
 * Created by denis on 04.09.16.
 */
public interface CategoryService extends BaseService<Category> {
    Category getByName(String name);
}
