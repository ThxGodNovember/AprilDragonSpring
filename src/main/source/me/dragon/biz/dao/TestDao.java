package me.dragon.biz.dao;

import me.dragon.base.dao.BaseDao;
import me.dragon.biz.entity.Person;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by dragon on 4/2/2017.
 */

@Repository
public interface TestDao extends BaseDao{
    List<Person> getList();
}
