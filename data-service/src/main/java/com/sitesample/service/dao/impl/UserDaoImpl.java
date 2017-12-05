package com.sitesample.service.dao.impl;

import com.sitesample.service.dao.UserDao;
import com.sitesample.service.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class UserDaoImpl extends AbstractDao<User> implements UserDao{

    @Autowired
    protected UserDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    protected Class<User> getEntityType() {
        return User.class;
    }

    @Override
    public User findByName(String name) {
        try(Session session = this.sessionFactory.openSession()) {
            TypedQuery<User> query = session.createQuery("from User where name=:name")
                    .setParameter("name", name);
            List<User> resultList = query.getResultList();
            if (resultList == null || resultList.isEmpty()) {
                return null;
            }
            return resultList.get(0);
        }
    }

    @Override
    public User findByEmail(String email) {
        try(Session session = this.sessionFactory.openSession()) {
            TypedQuery<User> query = session.createQuery("from User where email=:email")
                    .setParameter("email", email);
            List<User> resultList = query.getResultList();
            if (resultList == null || resultList.isEmpty()) {
                return null;
            }
            return resultList.get(0);
        }
    }
}
