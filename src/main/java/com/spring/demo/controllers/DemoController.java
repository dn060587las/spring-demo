package com.spring.demo.controllers;

import com.spring.demo.service.DemoService;
import java.sql.Connection;
import java.sql.ResultSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * DemoController.
 *
 * @author alitvinov
 */
@Controller
public class DemoController {

    @Autowired
    private DemoService demoService;
    
    @RequestMapping("/")
    public ModelAndView testDemoView() throws Exception {        
        ModelAndView view = new ModelAndView("test");
        view.addObject("data", demoService.readDataFromDatabase());
        return view;
    }

}
