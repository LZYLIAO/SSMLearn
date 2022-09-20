package com.liao.resolver;

import com.liao.exception.MyException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;

public class MyExceptionHandler implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView modelAndView=new ModelAndView();

        if(ex instanceof MyException){
//            System.out.println("自定义异常");
            modelAndView.addObject("info","自定义异常");
        }else if(ex instanceof FileNotFoundException){
//            System.out.println("类转换异常");
            modelAndView.addObject("info","文件找不到异常");
        }
        modelAndView.setViewName("error");
        return modelAndView;

    }
}
