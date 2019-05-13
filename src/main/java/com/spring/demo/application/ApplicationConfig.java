package com.spring.demo.application;

import com.spring.demo.config.DatabaseConfiguration;
import com.spring.demo.config.WebConfiguration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
public class ApplicationConfig implements WebApplicationInitializer {

    

    @Override
    public void onStartup(ServletContext sc) throws ServletException {
         
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(WebConfiguration.class, DatabaseConfiguration.class);
        ctx.setServletContext(sc);

        sc.addListener(new ContextLoaderListener(ctx));
 
        ServletRegistration.Dynamic dispatcher = sc.addServlet("dispatcher", new DispatcherServlet(ctx));        
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    
    }
    
    
}
