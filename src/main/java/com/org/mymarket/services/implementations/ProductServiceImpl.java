package com.org.mymarket.services.implementations;

import com.org.mymarket.dao.interfaces.ProductDAO;
import com.org.mymarket.model.Product;
import com.org.mymarket.services.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by denis on 02.07.16.
 */
@Service
@Component
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductDAO productDao;

    @Override
    @Transactional
    public void add(Product obj) {
        productDao.add(obj);
    }

    @Override
    @Transactional
    public void remove(Product obj) {
        productDao.remove(obj);
    }

    @Override
    @Transactional
    public void update(Product obj) { productDao.update(obj); }

    @Override
    @Transactional
    public Product getById(Long id) {
        return productDao.getById(id);
    }

    @Override
    @Transactional
    public List<Product> getList() {
        return productDao.getList();
    }

    @Override
    @Transactional
    public List<Product> getSortedProductListASC(String type) {
        return productDao.getSortedListASC(type);
    }

    @Override
    @Transactional
    public List<Product> getSortedProductListDESC(String type) {
        return productDao.getSortedListDESC(type);
    }
}
