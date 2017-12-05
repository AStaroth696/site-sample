package com.sitesample.service.dao;

import java.util.List;

public interface GenericDao<T> {
    public void create(T entity);

    public void update (T entity);

    public void remove (T entity);

    public T getById (int id);

    public List<T> getAll();
}
