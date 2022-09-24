package com.liao.proxy.cglib;

import com.liao.proxy.jdk.Target;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) {
        Target target=new Target();//创建目标对象
        Enhancer enhancer=new Enhancer();//增强器
        enhancer.setSuperclass(Target.class);//获得父类对象
        enhancer.setCallback(new MethodInterceptor() {//设置回调
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("before");
                Object invoke = method.invoke(target, objects);
                System.out.println("after");
                return invoke;
            }
        });
        Target proxy=(Target) enhancer.create();//创建代理对象
        proxy.method();
    }
}
