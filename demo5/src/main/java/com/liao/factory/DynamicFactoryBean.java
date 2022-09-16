package com.liao.factory;

import com.liao.dao.UserDao;
import com.liao.dao.impl.UserDaoImpl;

public class DynamicFactoryBean {
    public UserDao createUserDao(){
        return new UserDaoImpl();
    }
}
