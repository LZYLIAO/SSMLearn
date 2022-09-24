package com.liao.proxy.jdk;

public class Target implements TargetInterface{
    @Override
    public void method() {
        System.out.println("method running...");
    }
}
