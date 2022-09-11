package com.liao.web;

import com.liao.dao.UserDao;
import com.liao.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
//        ApplicationContext app= WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());

        ServletContext context=this.getServletContext();
        ApplicationContext app= WebApplicationContextUtils.getWebApplicationContext(context);
        UserService userService=(UserService) app.getBean("userService");
        userService.save();

//        UserDao userDao=(UserDao)app.getBean("userDao");
//        userDao.save();

    }
}
