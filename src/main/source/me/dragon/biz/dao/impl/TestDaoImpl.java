package me.dragon.biz.dao.impl;

import me.dragon.biz.dao.TestDao;
import me.dragon.biz.entity.Person;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dragon on 4/2/2017.
 */

@Repository
@EnableAutoConfiguration
public class TestDaoImpl implements TestDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Person> getList() {
        Session session = sessionFactory.openSession();
        List<Person> list = null;
        try {
            session.beginTransaction();
            String hql = "from Person";
            Query query = session.createQuery(hql);
            list = query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
