package com.org.mymarket.dao.implementations;

import com.org.mymarket.dao.interfaces.DealDAO;
import com.org.mymarket.model.Deal;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by denis on 02.07.16.
 */
@Component
public class DealDAOImpl extends BaseDAOImpl<Deal> implements DealDAO {
    @Override
    public List<Deal> getList() {
        Session session = this.sessionFactory.getCurrentSession();
        return session.createQuery("from Deal").list();

    }
}
