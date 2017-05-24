package com.tan.dao;

import com.tan.model.Article;
import com.tan.model.Article_category;
import org.hibernate.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tan on 2017/4/10.
 * by 谭钧豪
 */
public class ArticleDao {

    SessionFactory sessionFactory = null;
    Session session = null;
    Transaction tx;

    public ArticleDao() {
        sessionFactory = BaseDao.sessionFactory;
        session = sessionFactory.openSession();
        tx = null;
    }
    //增加
    public boolean insert(Article article) {
        try {
            tx = session.beginTransaction();
            session.save(article);
            tx.commit();
            return true;
        }catch (HibernateException e){
            System.out.println("ArticleDao insert() error:"+e.getCause().getLocalizedMessage());
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
    public Article getById(Integer id) {
        try {
            return session.get(Article.class, id);
        }catch (HibernateException e){
            return null;
        }finally {
            session.close();
        }
    }

    public List<Article> getAll() {
        try {
            Query query = session.createQuery("from Article article");
            List<Article> list = query.list();
            return list;
        }catch (HibernateException e){
            e.printStackTrace();
            return new ArrayList<Article>();
        }finally {
            session.close();
        }
    }

    public List<Article> getByCategoryId(String cid) {
        try {
            Query query = session.createQuery("from Article_category articleCategory where articleCategory.c_id = "+cid);
            List<Article_category> list = query.list();
            List<Article> articleList = new ArrayList<>();
            for (Article_category ac:list) {
                articleList.add(session.get(Article.class, ac.getA_id()));
            }
            return articleList;
        }catch (HibernateException e){
            e.printStackTrace();
            return new ArrayList<>();
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
