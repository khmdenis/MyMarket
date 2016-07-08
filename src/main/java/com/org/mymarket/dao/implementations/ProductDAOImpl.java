package com.org.mymarket.dao.implementations;

import com.org.mymarket.dao.interfaces.ProductDAO;
import com.org.mymarket.model.Product;
import org.springframework.stereotype.Component;

/**
 * Created by denis on 02.07.16.
 */
@Component
public class ProductDAOImpl extends BaseDAOImpl<Product> implements ProductDAO {
}
