package com.tan.dao;

import com.tan.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.Serializable;

/**
 * Created by 24429 on 2017/3/18.
 */
public class UserDao {

    SessionFactory sessionFactory = null;
    Session session = null;
    Transaction tx = null;

    public UserDao() {
        sessionFactory = BaseDao.config.buildSessionFactory();
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
    }
    //增加
    public boolean insert(User user) {
        try {
            session.save(user);
            tx.commit();
            return true;
        }catch (HibernateException e){
            System.out.println("UserDao insert() error:"+e.getCause().getLocalizedMessage());
            return false;
        }finally{
            session.close();
        }
    }
    //修改
    public boolean update(User user) {
        User newUser = session.get(User.class,user.getId());
        boolean isSucceed = false;
        try {
            session.update(newUser);
            tx.commit();
            isSucceed = true;
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            session.close();
        }
        return isSucceed;
    }
    //查找
    public User getByUsername(String username) {
        User user = session.get(User.class, username);
        tx.commit();
        session.close();
        return user;
    }

    //删除
    public void deleteById(Integer id) {
        session.delete("from user as u where u.id="+id);
        tx.commit();
        session.close();
    }

}
