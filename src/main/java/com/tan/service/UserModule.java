package com.tan.service;

import com.tan.dao.UserDao;
import com.tan.model.User;

/**
 * Created by 24429 on 2017/3/18.
 */
public class UserModule {

    public static boolean reg(User user){
        UserDao userDao = new UserDao();
        return userDao.insert(user);
    }

    public static boolean login(User user){
        UserDao userDao = new UserDao();
        User dbuser = userDao.getByUsername(user.getUsername());
        return dbuser.getPassword().equals(user.getPassword());
    }

}
