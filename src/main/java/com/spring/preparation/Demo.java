package com.spring.preparation;

import com.spring.preparation.config.ApplicationProperties;
import com.spring.preparation.controller.EmployeesController;
import com.spring.preparation.service.EmployeesService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

@ComponentScan
public class Demo {

    public void run() {
        System.out.println("Application is running");
        qualifierDemo();
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

    private void propertySourcesDemo() {
        final ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Demo.class);
        final ApplicationProperties applicationProperties = (ApplicationProperties) applicationContext.getBean("applicationProperties");
        final Environment environment = (Environment) applicationContext.getBean("environment");
        System.out.println("Application name from Environment bean: " + environment.getProperty("application.name"));
        System.out.println("Application name from properties file: " + applicationProperties.getApplicationName());
    }

    private void qualifierDemo() {
        final ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Demo.class);
        final EmployeesController employeesController = (EmployeesController) applicationContext.getBean("employeesController");
        System.out.println(employeesController.getAllEmployees());
    }
}
