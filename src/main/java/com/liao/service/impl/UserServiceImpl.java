package com.liao.service.impl;

import com.liao.User;
import com.liao.dao.UserDao;
import com.liao.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao;


    public UserServiceImpl() {
    }

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save() {

        userDao.save();
    }
}
