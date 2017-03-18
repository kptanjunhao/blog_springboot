package com.tan.service;

import com.tan.dao.UserDao;
import com.tan.model.User;

/**
 * Created by 24429 on 2017/3/18.
 */
public class Register {

    public static void reg(User user){
        UserDao userDao = new UserDao();
        userDao.insert(user);
    }

}
