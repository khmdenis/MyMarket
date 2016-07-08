package com.org.mymarket.dao.implementations;

import com.org.mymarket.dao.interfaces.BaseDAO;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by denis on 02.07.16.
 */
public class BaseDAOImpl<T> implements BaseDAO<T> {

    private Class<T> type;
    @Autowired
    protected SessionFactory sessionFactory;
    protected BaseDAOImpl(){
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        type = (Class<T>) pt.getActualTypeArguments()[0];

    }

    @Override
    public T add(T obj) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(obj);
        return obj;
    }

    @Override
    public T remove(T obj) {
        Session session = this.sessionFactory.getCurrentSession();
        session.delete(obj);
        return obj;
    }

    @Override
    public T update(T obj) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(obj);
        return obj;
    }

    @Override
    public List<T> getList() {
        Session session = this.sessionFactory.getCurrentSession();
        List<T> list = session.createCriteria(type).list();
        return list;
    }

    @Override
    public T getById(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(type);
        criteria.add(Restrictions.eq("id", id));
        T obj = (T) criteria.uniqueResult();
        return obj;
    }

    @Override
    public T getByName(String name) {
        Session session = this.sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(type);
        criteria.add(Restrictions.eq("name", name));
        T obj = (T) criteria.uniqueResult();
        return obj;
    }
}
