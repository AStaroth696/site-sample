package com.sitesample.service.dao.impl;

import com.sitesample.service.dao.GenericDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;

public abstract class AbstractDao<T> implements GenericDao<T>{

    final SessionFactory sessionFactory;

    protected AbstractDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public void create(T entity) {
        try(Session session = this.sessionFactory.openSession()) {
            session.saveOrUpdate(entity);
        }
    }
    @Override
    @Transactional
    public void update(T entity) {
        try(Session session = this.sessionFactory.openSession()) {
            session.update(entity);
        }
    }

    @Override
    @Transactional
    public void remove(T entity) {
        try(Session session = this.sessionFactory.openSession()) {
            session.remove(entity);
        }
    }

    @Override
    public T getById(int id) {
        try(Session session = this.sessionFactory.openSession()) {
            return session.get(getEntityType(), id);
        }
    }

    protected abstract Class<T> getEntityType();

    @Override
    public List getAll() {
        try(Session session = this.sessionFactory.openSession()) {
            TypedQuery<T> query = session.createQuery("from " + getEntityType().getSimpleName(), getEntityType());
            return query.getResultList();
        }
    }
}
