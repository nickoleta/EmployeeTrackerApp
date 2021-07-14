package com.spring.boot.preparation.service.impl;

import com.spring.boot.preparation.dao.EmployeesRepository;
import com.spring.boot.preparation.dto.Employee;
import com.spring.boot.preparation.service.EmployeesService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;
import java.util.List;

@RunWith(SpringRunner.class)
public class EmployeesServiceImplTest {

    @TestConfiguration
    static class EmployeesServiceConfig {
        @Bean
        public EmployeesService employeesService() {
            return new EmployeesServiceImpl();
        }
    }

    @Autowired
    private EmployeesService employeesService;

    @MockBean
    private EmployeesRepository employeesRepository;

    @Before
    public void init() {
        Mockito.when(employeesRepository.findAll()).thenReturn(List.of(
                new Employee("Alexander", "MID"),
                new Employee("Bob", "MID"),
                new Employee("Stanley", "CEO")));
    }

    @Test
    public void getAllEmployees_validRequest_listOfAllEmployees() {
        final Collection<Employee> actual = employeesService.getAllEmployees();

        Assertions.assertEquals(3, actual.toArray().length);
    }

}
