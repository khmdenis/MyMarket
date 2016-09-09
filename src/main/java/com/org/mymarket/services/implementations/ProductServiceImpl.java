package com.org.mymarket.services.implementations;

import com.org.mymarket.dao.interfaces.ProductDAO;
import com.org.mymarket.model.Category;
import com.org.mymarket.model.Product;
import com.org.mymarket.services.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.List;

/**
 * Created by denis on 02.07.16.
 */
@Service
@Component
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductDAO productDao;
    static int way = 0;

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
    public void remove(Long id) {
        Product product = productDao.getById(id);
        if (product.getImage() != null) {
            String dir = product.getImage().getImagePath();
            System.out.println(dir);
            File file = new File(dir);
            file.delete();
        }
        productDao.remove(product);
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
    public List<Product> getSortedProductListAscOrDesc(String type) {
        if (way == 0) {
            way = 1;
            return productDao.getSortedListASC(type);
        } else {
            way = 0;
            return productDao.getSortedListDESC(type);
        }
    }


    @Override
    @Transactional
    public List<Product> getListByCategory(Category category) {
        return productDao.getListByCategory(category);
    }
}
