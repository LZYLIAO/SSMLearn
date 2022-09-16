package com.liao.controller;

import com.liao.User;
import com.liao.Vo;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
public class TestController {
    @RequestMapping(value = "/t1")
    @ResponseBody
    public void t1(String name){
        System.out.println(name);
    }
    @RequestMapping("/t2")
    @ResponseBody
    public void t2(@RequestParam(value = "name") String username){
        System.out.println(username);
    }
    @RequestMapping(path = "/t3/{name}")
    @ResponseBody
    public void t3(@PathVariable(value = "name") String username){
        System.out.println(username);
    }
    @RequestMapping("/t4")
    @ResponseBody
    public void t4( User user){
        System.out.println(user);
    }
    @RequestMapping("/t5")
    @ResponseBody
    public void t5(@RequestParam("name") String username,@RequestParam("age") int userAge){
        System.out.println(username);
        System.out.println(userAge);
    }
    @RequestMapping("/t6")
    @ResponseBody
    public void t6(String[] strs){
        System.out.println(Arrays.asList(strs));
    }
    @RequestMapping("/t7")
    @ResponseBody
    public void t7(Vo vo){
        System.out.println(vo.getUserList());
    }
    @RequestMapping("/t8")
    @ResponseBody
    public void t8(@RequestBody List<User> userList){
        System.out.println(userList);
    }

    @RequestMapping("/t9")
    @ResponseBody
    public void t9(@DateTimeFormat(pattern = "yyyy-MM-dd") Date date){
        System.out.println(date);
    }
}
