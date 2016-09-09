package com.org.mymarket.services.implementations;

import com.org.mymarket.dao.interfaces.CategoryDAO;
import com.org.mymarket.model.Category;
import com.org.mymarket.services.interfaces.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDAO categoryDAO;

    @Override
    @Transactional
    public void add(Category obj) {
        categoryDAO.add(obj);
    }

    @Override
    @Transactional
    public void remove(Category obj) {
        categoryDAO.remove(obj);
    }

    @Override
    @Transactional
    public void update(Category obj) {
        categoryDAO.update(obj);
    }

    @Override
    @Transactional
    public Category getById(Long id) {
        return categoryDAO.getById(id);
    }

    @Override
    @Transactional
    public List<Category> getList() {
        return categoryDAO.getList();
    }

    @Override
    @Transactional
    public Category getByName(String name) {
        return categoryDAO.getByName(name);
    }
}
