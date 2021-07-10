package com.spring.preparation;

import com.spring.preparation.aop.aspects.custom.TracingAdvice;
import com.spring.preparation.config.ApplicationProperties;
import com.spring.preparation.config.SpelConfig;
import com.spring.preparation.controller.EmployeesController;
import com.spring.preparation.dao.EmployeesDao;
import com.spring.preparation.dao.impl.EmployeesDaoImpl;
import com.spring.preparation.service.EmployeesService;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.env.Environment;

@ComponentScan
@EnableAspectJAutoProxy
public class Demo {

    public void run() {
        System.out.println("Application is running");
        aopCustomAdviceDemo();
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

    private void spelDemo() {
        final ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Demo.class);
        final SpelConfig spelConfig = (SpelConfig) applicationContext.getBean("spelConfig");
        System.out.println(spelConfig.arithmeticOperation);
        System.out.println(spelConfig.arithmeticOperationWithStrings);
        System.out.println(spelConfig.arithmeticOperationDiv);
        System.out.println(spelConfig.logicalOperation);
        System.out.println(spelConfig.logicalOperation2);
        System.out.println(spelConfig.conditionalOperation);
        System.out.println(spelConfig.matchesOperation);
    }

    private void aopDemo() {
        final ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Demo.class);
        final EmployeesDao employeesDao = (EmployeesDao) applicationContext.getBean("employeesDaoImpl");
        employeesDao.getAllEmployees();

        final EmployeesService employeesService = (EmployeesService) applicationContext.getBean("employeesServiceImpl");
        employeesService.getAllEmployees();

        final EmployeesService employeesService2 = (EmployeesService) applicationContext.getBean("traineesServiceImpl");
        employeesService2.getAllEmployees();

        final EmployeesController employeesController = (EmployeesController) applicationContext.getBean("employeesController");
        employeesController.getAllEmployees();
    }

    private void aopCustomAdviceDemo() {
        final ProxyFactory proxyFactory = new ProxyFactory(new EmployeesDaoImpl());
        proxyFactory.addInterface(EmployeesDao.class);
        proxyFactory.addAdvice(new TracingAdvice());

        final EmployeesDao proxy = (EmployeesDao) proxyFactory.getProxy();
        System.out.println(proxy.getAllEmployees());
    }
}
