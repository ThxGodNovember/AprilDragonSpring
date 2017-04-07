package me.dragon.biz.dao.impl;

import me.dragon.base.core.Page;
import me.dragon.base.dao.GenericDao;
import me.dragon.biz.dao.TestDao;
import me.dragon.biz.entity.Person;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dragon on 4/2/2017.
 */

@Repository
public class TestDaoImpl extends GenericDao implements TestDao{

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

    @Override
    public Person getSinglePerson() {
        Person person = new Person();
        try{
            String hql = "from Person where id = ?";
            person = (Person) findUnique(hql,1L);
        }catch (Exception e){
            e.printStackTrace();
        }
        return person;
    }

    @Override
    public void saveSinglePerson() {
        Person person = new Person();
        try{
            person.setName("dragon");
            person.setSex("man");
            save(person);
            logger.info("保存成功");
        }catch (Exception e){
            logger.info("保存失败");
            e.printStackTrace();
        }
    }

    @Override
    public void updateSinglePerson() {
        Person person = new Person();
        try{
            String hql = "from Person where id = ?";
            person = (Person) findUnique(hql,1L);
            person.setName("dragon-yuan");
            person.setSex("man");
            save(person);
            logger.info("更新成功");
        }catch (Exception e){
            logger.info("更新失败");
            e.printStackTrace();
        }
    }

    @Override
    public void deleteSinglePerson() {
        try{
            String hql = "from Person where id = ?";
            Person person = (Person) findUnique(hql,2L);
            delete(person);
            logger.info("删除成功");
        }catch (Exception e){
            logger.info("删除失败");
            e.printStackTrace();
        }
    }

    @Override
    public Page<Person> getPage(int pageNum) {
        Page<Person> personPage = new Page<Person>();
        try{
            String sql = "select * from Person";
            personPage = findPageWithSQL(sql,1,pageNum,Person.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        return personPage;
    }

    @Override
    public Page<Person> getResultWithPage(Page flagPage) {
        Page<Person> personPage = new Page<Person>();
        try{
            String sql = "select * from Person";
            personPage = findPageWithSQL(sql,flagPage.getPageSize(),flagPage.getPageNo(),Person.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        return personPage;
    }
}
