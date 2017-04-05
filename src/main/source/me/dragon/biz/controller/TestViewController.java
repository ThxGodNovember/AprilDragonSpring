package me.dragon.biz.controller;

import me.dragon.base.controller.GenericController;
import me.dragon.base.core.Page;
import me.dragon.biz.entity.Person;
import me.dragon.biz.service.TestService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by dragon on 4/5/2017.
 */
@Controller
@EnableAutoConfiguration
public class TestViewController extends GenericController{
    Logger log = Logger.getLogger(TestViewController.class);
    @Autowired
    private TestService testService;
    /**
     * Object
     */
    private String nameStr;
    private String pageNum = "1";

    @RequestMapping("/view.do")
    public ModelAndView testSpringBootView() {
        ModelMap params = new ModelMap();
        params.addAttribute("nameStr", "testView-nameStr");
        ModelAndView modelAndView = new ModelAndView("view", params);
        return modelAndView;
    }

    @RequestMapping("/view-select.do")
    public String select(){
        String selectStr = "";
        try {
            selectStr = testService.getList().toString();
            ajaxSuccess(selectStr);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/page.do")
    public ModelAndView showPage(@RequestParam(defaultValue  = "1")String pageNum) {
        ModelAndView modelAndView = null;
        try {
            ModelMap params = new ModelMap();
            Page<Person> personPage = testService.getPage(Integer.parseInt(pageNum));
            params.addAttribute("personPage", personPage);
            modelAndView = new ModelAndView("page", params);
        }catch (Exception e){
            e.printStackTrace();
        }
        return modelAndView;
    }

}
