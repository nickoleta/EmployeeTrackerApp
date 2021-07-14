package com.spring.boot.preparation.controller;

import com.spring.boot.preparation.dto.Employee;
import com.spring.boot.preparation.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("employees")
public class EmployeesController {

    private final EmployeesService employeesService;

    @Autowired
    public EmployeesController(EmployeesService employeesService) {
        this.employeesService = employeesService;
    }

    @GetMapping
    public Collection<Employee> getAllEmployees() {
        return employeesService.getAllEmployees();
    }

    @GetMapping("/{employeeName}")
    public ResponseEntity<Employee> getEmployee(@PathVariable("employeeName") final String employeeName) {
        final Employee employee = employeesService.getEmployee(employeeName);
        if(employee == null) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping
    public void addEmployee(@RequestBody final Employee employee) {
        employeesService.addEmployee(employee);
    }
}
