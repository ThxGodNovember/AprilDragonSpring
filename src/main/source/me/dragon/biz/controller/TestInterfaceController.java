package me.dragon.biz.controller;

import me.dragon.biz.entity.Person;
import me.dragon.biz.service.TestService;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dragon on 4/2/2017.
 */
@RestController
@EnableAutoConfiguration
public class TestInterfaceController {
    Logger log = Logger.getLogger(TestInterfaceController.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private TestService testService;

    @RequestMapping("/select")
    public String select(){
        String selectStr = "";
        try {
            selectStr = testService.getList().toString();
        }catch (Exception e){
            System.out.println("TestController : sessionFactory = " + sessionFactory);
            e.printStackTrace();
        }
        return selectStr;
    }

    @RequestMapping("/select-single")
    public String selectSingle(){
        Person person = new Person();
        try {
            person = testService.getSinglePerson();
        }catch (Exception e){
            e.printStackTrace();
        }
        return person.toString();
    }

    @RequestMapping("/save")
    public String saveSingle(){
        try {
            testService.saveSinglePerson();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/update")
    public String updateSingle(){
        try {
            testService.updateSinglePerson();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/delete")
    public String deleteSingle(){
        try {
            testService.deleteSinglePerson();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
