package com.spring.preparation.controller;

import com.spring.preparation.aop.aspects.Loggable;
import com.spring.preparation.dto.Employee;
import com.spring.preparation.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("employees")
public class EmployeesController {

    private final EmployeesService employeesService;

    @Autowired
    public EmployeesController(@Qualifier("employeesServiceImpl") EmployeesService employeesService) {
        this.employeesService = employeesService;
    }

    @Loggable
    @GetMapping()
    public Collection<Employee> getAllEmployees() {
        return employeesService.getAllEmployees();
    }

    @GetMapping("/{employeeName}")
    public Employee getEmployee(@PathVariable("employeeName") final String employeeName) {
        return employeesService.getEmployee(employeeName);
    }

    @PostMapping("")
    public void addEmployee(@RequestBody final Employee employee) {
        employeesService.addEmployee(employee);
    }
}
