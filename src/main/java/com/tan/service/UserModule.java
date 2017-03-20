package com.tan.service;

import com.tan.dao.UserDao;
import com.tan.model.User;

/**
 * Created by 24429 on 2017/3/18.
 */
public class UserModule {

    /*
    * 返回：用户存在true   不存在false
    * */
    public static boolean checkUserExist(String username){
        User user = new UserDao().getByUsername(username);
        return (user != null);
    }

    public static boolean reg(User user){
        UserDao userDao = new UserDao();
        if (user.checkUserNameOrPasswordIsEmpty()){ return false; }
        return userDao.insert(user);
    }

    public static boolean login(User user){
        UserDao userDao = new UserDao();
        if (user.checkUserNameOrPasswordIsEmpty()){ return false; }
        User dbuser = userDao.getByUsername(user.getUsername());
        return dbuser.getPassword().equals(user.getPassword());
    }

}
