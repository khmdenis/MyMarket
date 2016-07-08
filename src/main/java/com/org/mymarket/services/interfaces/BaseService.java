package com.org.mymarket.services.interfaces;

import java.util.List;

/**
 * Created by denis on 02.07.16.
 */
public interface BaseService<T> {
    public void add(T obj);
    public void remove(T obj);
    public void update(T obj);
    public T getById(Long id);
    public List<T> getList();
}
