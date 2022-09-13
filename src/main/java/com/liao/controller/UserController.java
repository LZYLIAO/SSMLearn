package com.liao.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.liao.User;
import com.liao.Vo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

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
    @RequestMapping("/quick10")
    @ResponseBody
    public void getRequestData1(String username,int age){
//        方法的参数名称要和请求参数名称一致
        System.out.println(username);
        System.out.println(age);
    }
    @RequestMapping("/quick11")
    @ResponseBody
    //对象形式
    public void getRequestData2(User user){
//        类的属性名称要和请求参数名称一致
        System.out.println(user);
    }
    //数组形式
    //传参： ?strs=xx&strs=xx&strs=xx
    @RequestMapping("/quick12")
    @ResponseBody
    public void getRequestData3(String[] strs){
        System.out.println(Arrays.asList(strs));
    }

    @RequestMapping("/quick13")
    @ResponseBody
    //集合的形式，需要将集合封装进一个类中
    public void getRequestData3(Vo vo){
        System.out.println(vo.getUserList());
    }
    @RequestMapping("/quick14")
    @ResponseBody
    public void getRequestData4(@RequestBody List<User> userList){
        System.out.println(userList);
    }
    @RequestMapping("/quick15")
    @ResponseBody
    // 使用注解进行参数绑定
    // value 传过来的参数名称
    // required 是否必须
    // defaultValue 默认的值
    public void getRequestData5(@RequestParam(value = "name",required = false,defaultValue = "lzy") String username){
        System.out.println(username);
    }
    //获得Restful风格的参数
    @RequestMapping("/quick16/{name}")
    @ResponseBody
    public void getRequestData6(@PathVariable(value = "name") String username){
        System.out.println(username);
    }
    @RequestMapping("/quick17")
    @ResponseBody
    public void getRequestData6(Date date){
        System.out.println(date);
    }

    @RequestMapping("/quick18")
    @ResponseBody
    public void testMethod1(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse,
                           HttpSession httpSession){

        System.out.println(httpServletRequest);
        System.out.println(httpServletResponse);
        System.out.println(httpSession);

    }
    @RequestMapping("/quick19")
    @ResponseBody
    public void testMethod2(@RequestHeader(value = "User-Agent",required = false) String headerVal){
        System.out.println(headerVal);
    }
    @RequestMapping("/quick20")
    @ResponseBody
    public void testMethod3(@CookieValue(value = "JSESSIONID",required = false) String jsessionid){
        System.out.println(jsessionid);

    }

}
