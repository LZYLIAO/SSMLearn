package com.liao.listener;

import org.springframework.context.ApplicationContext;

import javax.servlet.ServletContext;

public class WebApplicationContextUtils {
    public static ApplicationContext getWebApplicationContext(ServletContext context){
        return (ApplicationContext) context.getAttribute("app");
    }
}
