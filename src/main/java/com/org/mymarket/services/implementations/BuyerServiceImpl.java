package com.org.mymarket.services.implementations;

import com.org.mymarket.dao.interfaces.BuyerDAO;
import com.org.mymarket.model.Buyer;
import com.org.mymarket.services.interfaces.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by denis on 02.07.16.
 */
@Component
public class BuyerServiceImpl implements BuyerService {
    @Autowired
    BuyerDAO buyerDao;

    @Override
    @Transactional
    public void add(Buyer obj) {
        buyerDao.add(obj);
    }

    @Override
    @Transactional
    public void remove(Buyer obj) {
        buyerDao.remove(obj);
    }

    @Override
    @Transactional
    public void update(Buyer obj) {
        buyerDao.update(obj);
    }

    @Override
    @Transactional
    public Buyer getById(Long id) {
        return buyerDao.getById(id);
    }

    @Override
    @Transactional
    public List<Buyer> getList() {
        return buyerDao.getList();
    }
}
