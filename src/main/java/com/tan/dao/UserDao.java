package com.tan.dao;

import com.tan.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.Serializable;

/**
 * Created by 24429 on 2017/3/18.
 */
public class UserDao {

    Configuration config = null;
    SessionFactory sessionFactory = null;
    Session session = null;
    Transaction tx = null;

    public UserDao() {
        config = new Configuration().configure();
        sessionFactory = config.buildSessionFactory();
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
    }
    //增加
    public void insert(User user) {;
        session.save(user);
        tx.commit();
        session.close();
    }
    //修改
    public void update(User user) {
        User newUser = session.get(User.class,user.getId());
        session.update(newUser);
        tx.commit();
        session.close();
    }
    //查找
    public User getById(Integer id) {
        User user = session.get(User.class, id);
        tx.commit();
        session.close();
        return user;
    }
    //删除
    public void deleteById(Integer id) {
        session.delete("from Customer as c where c.id="+id);
        tx.commit();
        session.close();
    }

}
