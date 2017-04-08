package com.tan.dao;

import com.tan.model.Category;
import org.hibernate.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tan on 2017/4/7.
 * by 谭钧豪
 */
public class CategoryDao {


    SessionFactory sessionFactory = null;
    Session session = null;
    Transaction tx;

    public CategoryDao() {
        sessionFactory = BaseDao.sessionFactory;
        session = sessionFactory.openSession();
        tx = null;
    }
    //增加
    public boolean insert(Category category) {
        try {
            tx = session.beginTransaction();
            session.save(category);
            tx.commit();
            return true;
        }catch (HibernateException e){
            System.out.println("CategoryDao insert() error:"+e.getCause().getLocalizedMessage());
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
    public Category getById(Integer id) {
        try {
            return session.get(Category.class, id);
        }catch (HibernateException e){
            return null;
        }finally {
            session.close();
        }
    }

    public List<Category> getAll() {
        try {
            Query query = session.createQuery("from Category category");
            List<Category> list = query.list();
            return list;
        }catch (HibernateException e){
            e.printStackTrace();
            return new ArrayList<Category>();
        }finally {
            session.close();
        }
    }

    //删除
//    public boolean deleteById(Integer id) {
//        try {
//            tx = session.beginTransaction();
//            session.delete("from category as c where c.id=" + id);
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
