package com.liao.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.liao.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//一个注解就可以让java类变成处理请求的控制器！！！
@Controller
public class UserController {
    //页面跳转，返回字符串方式
    //    映射
    @RequestMapping("/quick1")
    public String pageJump1(){
        System.out.println("save()......");
        //跳转到success.jsp
        return "success";
    }
    //页面跳转，返回ModelAndView
    @RequestMapping("/quick2")
    public ModelAndView pageJump2(){
        ModelAndView modelAndView=new ModelAndView();
        //设置模型数据
        modelAndView.addObject("username","lzy");
        //设置模型名称
        modelAndView.setViewName("success");
        return modelAndView;
    }
    // 框架很人性化，如果参数是ModelAndView，将会自动注入
    @RequestMapping("/quick3")
    public ModelAndView pageJump3(ModelAndView modelAndView){
        modelAndView.setViewName("success");
        modelAndView.addObject("username","save2");
        return modelAndView;
    }
    // 可以单独注入Model
    @RequestMapping("/quick4")
    public String pageJump4(Model model){
        model.addAttribute("username","save4");
        return "success";
    }
    //当然也可以注入HttpServletRequest，但很少这样做
    @RequestMapping("/quick5")
    public String pageJump5(HttpServletRequest request){
        request.setAttribute("username","save5");
        return "success";
    }
    //回写数据
    @RequestMapping("/quick6")
    public void returnData1(HttpServletResponse response) throws IOException {
        response.getWriter().print("Hi-1");
    }
    //要加上ResponseBody注解
    @RequestMapping("/quick7")
    @ResponseBody
    public String returnData2(){
        return "Hi-2";
    }
    //返回json字符串
    @RequestMapping("/quick8")
    @ResponseBody
    public String returnData3() throws JsonProcessingException {
        User user=new User();
        user.setUserAge(19);
        user.setUsername("Tom");
        //别忘了添加gson的依赖
//        Gson gson=new Gson();
//        String jsonStr=gson.toJson(user);

        //用jackson进行json的转换
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(user);
        return s;
    }

    //直接返回对象或集合（需要配置）
    @RequestMapping("/quick9")
    @ResponseBody
    public User returnData4() {
        User user=new User();
        user.setUserAge(19);
        user.setUsername("Tom");

        return user;
    }

}
