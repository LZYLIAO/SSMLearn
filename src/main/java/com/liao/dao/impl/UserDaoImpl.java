package com.liao.dao.impl;

import com.liao.User;
import com.liao.dao.UserDao;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class UserDaoImpl implements UserDao {

    private String name;
    private int age;

    private List<String> strList;
    private List<User>  userList;
    private Properties properties;
    private Map<String,User> map;

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public Map<String, User> getMap() {
        return map;
    }

    public void setMap(Map<String, User> map) {
        this.map = map;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public List<String> getStrList() {
        return strList;
    }

    public void setStrList(List<String> strList) {
        this.strList = strList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void save() {

        System.out.println(name);
        System.out.println(age);
        System.out.println(strList);
        for (User u:userList) {
            System.out.println(u.getUserAge());
            System.out.println(u.getUsername());

        }
        System.out.println(properties);
        System.out.println(map);
        System.out.println("UserDaoImpl -----> save()");
    }

    public void init(){
        System.out.println("init()");
    }
    public  void destroy(){
        System.out.println("destroy()");
    }
}
