package com.spring.boot.preparation.service;

import com.spring.boot.preparation.dto.Employee;

import java.util.Collection;

public interface EmployeesService {

    Collection<Employee> getAllEmployees();

    Employee getEmployee(String name);

    void addEmployee(Employee employee);
}
