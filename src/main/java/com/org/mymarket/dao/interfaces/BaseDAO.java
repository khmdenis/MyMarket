package com.org.mymarket.dao.interfaces;

import java.util.List;

/**
 * Created by denis on 02.07.16.
 */
public interface BaseDAO<T> {
    T add(T obj);

    T remove(T obj);

    T update(T obj);

    List<T> getList();

    T getById(Long id);

    T getByName(String name);
}
