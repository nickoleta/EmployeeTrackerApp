package com.spring.preparation.controller;

import com.spring.preparation.dto.Employee;
import com.spring.preparation.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import java.util.Collection;

@Controller
public class EmployeesController {

    private final EmployeesService employeesService;

    @Autowired
    public EmployeesController(@Qualifier("employeesServiceImpl") EmployeesService employeesService) {
        this.employeesService = employeesService;
    }

    public Collection<Employee> getAllEmployees() {
        return employeesService.getAllEmployees();
    }
}
