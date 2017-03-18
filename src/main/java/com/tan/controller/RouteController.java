package com.tan.controller;

import com.tan.model.User;
import com.tan.service.Register;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by 24429 on 2017/3/18.
 */

@RestController
public class RouteController {

    @RequestMapping(value = "/")
    public String index(){
        return "Hello World!";
    }

    @RequestMapping(value = "register")
    public String register(User user){
        user.setCreatetime(new Date());
        Register.reg(user);
        return "register";
    }

}
