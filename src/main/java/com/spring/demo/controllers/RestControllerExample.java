
package com.spring.demo.controllers;

import com.spring.demo.application.domain.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author alitvinov
 */
@RestController
public class RestControllerExample {
    
    @GetMapping(value = "rest/some-string")
    public User getSomeString() {
        User result = new User("test");
        return result;
    }
}
