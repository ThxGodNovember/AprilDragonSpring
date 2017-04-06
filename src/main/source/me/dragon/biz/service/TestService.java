package me.dragon.biz.service;

import me.dragon.base.core.Page;
import me.dragon.base.service.BaseService;
import me.dragon.biz.entity.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by dragon on 4/2/2017.
 */
@Service
public interface TestService extends BaseService{
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
