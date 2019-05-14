package com.spring.demo.controllers;

import com.spring.demo.service.DemoService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
    @Qualifier(value = "demoService")
    private DemoService demoService;
    
    @RequestMapping("/")
    public ModelAndView testDemoView(HttpServletRequest request) throws Exception {        
        ModelAndView view = new ModelAndView("test");
        view.addObject("data", demoService.readDataFromDatabase());
        view.addObject("someVar", "121212");
        return view;
    }
}
