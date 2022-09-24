package com.liao.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
        Target target=new Target();
        TargetInterface proxyInstance=(TargetInterface) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                System.out.println("before");
                Object invoke=method.invoke(target,args);
                System.out.println("after");
                return invoke;
            }
        });
        proxyInstance.method();





    }
}
