package com.sitesample.service.dao;

import com.sitesample.service.model.User;

public interface UserDao extends GenericDao<User> {
    public User findByName(String name);
    public User findByEmail(String email);
}
