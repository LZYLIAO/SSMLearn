package com.liao.factory;

import com.liao.dao.UserDao;
import com.liao.dao.impl.UserDaoImpl;

// 静态工厂
public class StaticFactoryBean {
    public static UserDao createUserDao(){
        return new UserDaoImpl();
    }
}
