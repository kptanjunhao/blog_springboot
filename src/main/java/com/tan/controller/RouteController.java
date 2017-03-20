package com.tan.controller;

import com.tan.model.User;
import com.tan.service.UserModule;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 24429 on 2017/3/18.
 * by 谭钧豪
 */

@RestController
public class RouteController {

    @RequestMapping(value = "index")
    public String index(){
        return "Hello World! spring boot hibernate blog";
    }

    @RequestMapping(value = "register")
    public String register(User user){
        user.setCreatetime(new Date());
        Map<String,String> result = new HashMap<>();
        if (!UserModule.checkUserExist(user.getUsername())) {
            result.put("statu", UserModule.reg(user)+"");
            result.put("msg", "注册失败");
        } else {
            result.put("statu", "false");
            result.put("msg", "用户名已存在");
        }
        return result.toString();
    }

    @RequestMapping(value ="login")
    public String login(User user){
        Map<String,String> result = new HashMap<>();
        result.put("statu",UserModule.login(user)+"");
        result.put("msg","登陆");
        return result.toString();
    }

}
