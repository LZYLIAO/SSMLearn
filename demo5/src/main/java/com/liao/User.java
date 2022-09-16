package com.liao;

public class User {
    private String username;
    private int userAge;

    public User() {


    }

    public User(String username, int userAge) {
        this.username = username;
        this.userAge = userAge;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    @Override
    public String toString() {
        return "User{" + "username='" + username + '\'' + ", userAge=" + userAge + '}';
    }
}
