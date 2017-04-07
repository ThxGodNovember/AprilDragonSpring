package me.dragon.biz.dao;

import me.dragon.base.core.Page;
import me.dragon.base.dao.BaseDao;
import me.dragon.biz.entity.Person;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by dragon on 4/2/2017.
 */

@Repository
public interface TestDao extends BaseDao{
    // select
    List<Person> getList();
    Page<Person> getPage(int pageNum);
    Page<Person> getResultWithPage(Page flagPage);
    Person getSinglePerson();
    // insert
    void saveSinglePerson();
    // update
    void updateSinglePerson();
    // delete
    void deleteSinglePerson();
}
