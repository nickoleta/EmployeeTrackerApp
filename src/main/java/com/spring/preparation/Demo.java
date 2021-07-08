package com.spring.preparation;

import com.spring.preparation.service.EmployeesService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class Demo {

    public void run() {
        System.out.println("Application is running");
        beanLifecycleDemo();
    }

    private void containerDemo() {
        final ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Demo.class);
        final EmployeesService employeesService = (EmployeesService) applicationContext.getBean("employeesServiceImpl");
        System.out.println(employeesService.getAllEmployees());
    }

    private void beanLifecycleDemo() {
        final ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Demo.class);
        applicationContext.getBean("beanLifecycle");
    }
}
