package com.tan.dao;

import com.tan.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


/**
 * Created by 24429 on 2017/3/18.
 * by 谭钧豪
 */
public class UserDao {

    SessionFactory sessionFactory = null;
    Session session = null;
    Transaction tx;

    public UserDao() {
        sessionFactory = BaseDao.config.buildSessionFactory();
        session = sessionFactory.openSession();
        tx = null;
    }
    //增加
    public boolean insert(User user) {
        try {
            tx = session.beginTransaction();
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
//    public boolean update(User user) {
//        User newUser = session.get(User.class,user.getId());
//        try {
//            tx = session.beginTransaction();
//            session.update(newUser);
//            tx.commit();
//            return true;
//        }catch (HibernateException e){
//            e.printStackTrace();
//            return false;
//        }finally{
//            session.close();
//        }
//    }

    //查找
    public User getByUsername(String username) {
        try {
            return session.get(User.class, username);
        }catch (HibernateException e){
            return null;
        }finally {
            session.close();
        }
    }

    //删除
//    public boolean deleteById(Integer id) {
//        try {
//            tx = session.beginTransaction();
//            session.delete("from user as u where u.id=" + id);
//            tx.commit();
//            return true;
//        }catch (HibernateException e){
//            return false;
//        }
//        finally {
//            session.close();
//        }
//    }

}
