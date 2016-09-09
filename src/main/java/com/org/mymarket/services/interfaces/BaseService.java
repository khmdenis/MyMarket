package com.org.mymarket.services.interfaces;

import java.util.List;

/**
 * Created by denis on 02.07.16.
 */
public interface BaseService<T> {
    void add(T obj);

    void remove(T obj);

    void update(T obj);

    T getById(Long id);

    List<T> getList();
}
