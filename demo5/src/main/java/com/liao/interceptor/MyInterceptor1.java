package com.liao.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor1 implements HandlerInterceptor {
    @Override
//    目标方法执行前
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle...");
//可以在这里做一些处理
        String p = request.getParameter("p");
        if("yes".equals(p)){
            return true;
        }else {
            request.getRequestDispatcher("/jsp/error.jsp").forward(request,response);
            return false;
        }

//        如果返回false则后面的方法都不会执行
//        return false;
//        return true;
    }
//目标方法执行后，返回视图之前
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        //        在这个方法里可以修改视图的参数
        modelAndView.addObject("username","lzy");
        System.out.println("postHandle...");
    }

    @Override
//    目标方法执行结束后
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion...");
    }
}
