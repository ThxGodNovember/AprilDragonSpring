package me.dragon.biz.controller;

import me.dragon.base.controller.RestControllerDemo;
import me.dragon.biz.entity.Person;
import me.dragon.biz.service.TestService;
import me.dragon.biz.service.impl.TestServiceImpl;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dragon on 4/2/2017.
 */
@RestController
@EnableAutoConfiguration
public class TestController {
    Logger log = Logger.getLogger(TestController.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private TestService testService;

    @RequestMapping("/select")
    public String word(){
        String selectStr = "";
        try {
            selectStr = testService.getList().toString();
        }catch (Exception e){
            System.out.println("TestController : sessionFactory = " + sessionFactory);
            e.printStackTrace();
        }
        return selectStr;
    }

}
