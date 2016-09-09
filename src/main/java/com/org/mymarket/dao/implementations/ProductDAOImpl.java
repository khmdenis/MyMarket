package com.org.mymarket.dao.implementations;

import com.org.mymarket.dao.interfaces.ProductDAO;
import com.org.mymarket.model.Category;
import com.org.mymarket.model.Product;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by denis on 02.07.16.
 */
@Component
public class ProductDAOImpl extends BaseDAOImpl<Product> implements ProductDAO {

    @Override
    public List<Product> getSortedListASC(String type) {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Product.class).addOrder(Order.asc(type)).list();
    }

    @Override
    public List<Product> getSortedListDESC(String type) {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Product.class).addOrder(Order.desc(type)).list();

    }

    @Override
    public List<Product> getListByCategory(Category category) {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Product.class).add(Restrictions.eq("category", category)).list();
    }
}
