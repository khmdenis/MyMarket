package com.org.mymarket.services.implementations;

import com.org.mymarket.dao.interfaces.DealDAO;
import com.org.mymarket.model.Deal;
import com.org.mymarket.services.interfaces.DealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by denis on 02.07.16.
 */
@Component
public class DealServiceImpl implements DealService {
    @Autowired
    DealDAO dealDao;

    @Override
    @Transactional
    public void add(Deal obj) {
        dealDao.add(obj);
    }

    @Override
    @Transactional
    public void remove(Deal obj) {
        dealDao.remove(obj);
    }

    @Override
    @Transactional
    public void update(Deal obj) {
        dealDao.update(obj);
    }

    @Override
    @Transactional
    public Deal getById(Long id) {
        return dealDao.getById(id);
    }

    @Override
    @Transactional
    public List<Deal> getList() {
        return dealDao.getList();
    }
}
