package com.tan.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tan.model.User;
import com.tan.service.UserModule;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 24429 on 2017/3/18.
 * by 谭钧豪
 */

@RestController
public class RouteController {

//    @RequestMapping("/")
//    public String index(){
//        return "hello wolrd";
//    }
    @RequestMapping("/")
    public ModelAndView index(){
        return new ModelAndView("index.html");
    }

    @RequestMapping(value = "test")
    public String test(){
        JSONObject result = new JSONObject();
        List<String> items = new ArrayList();
        items.add("主页");
        items.add("列表");
        result.put("statu",true);
        result.put("msg","success");
        result.put("data",items);
        return result.toJSONString();
    }

    @RequestMapping(value = "register")
    public String register(User user){
        user.setCreatetime(new Date());
        JSONObject result = new JSONObject();
        if (!UserModule.checkUserExist(user.getUsername())) {
            result.put("statu", UserModule.reg(user)+"");
            result.put("msg", "注册失败");
        } else {
            result.put("statu", "false");
            result.put("msg", "用户名已存在");
        }
        return JSON.toJSONString(result);
    }

    @RequestMapping(value ="login")
    public String login(User user){
        JSONObject result = new JSONObject();
        result.put("statu",UserModule.login(user)+"");
        result.put("msg","登陆");
        return JSON.toJSONString(result);
    }

}
