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
        Map result = new HashMap();
        result.put("statu",UserModule.reg(user));
        result.put("msg","注册失败");
        return result.toString();
    }

    @RequestMapping(value ="login")
    public String login(User user){
        Map result = new HashMap();
        result.put("statu",UserModule.login(user));
        result.put("msg","注册失败");
        return result.toString();
    }

}
