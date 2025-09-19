package com.nan19.springbootautoconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringbootAutoConfigApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(SpringbootAutoConfigApplication.class, args);
        System.out.println(applicationContext.getBean("dispatcherServlet"));
        System.out.println(applicationContext.getBean("province"));
    }

}
