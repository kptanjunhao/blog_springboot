package com.tan.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by 24429 on 2017/3/18.
 * by 谭钧豪
 */
public final class BaseDao {
    static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
}
