package com.spring.preparation.service;

import com.spring.preparation.dto.Employee;

import java.util.Collection;

public interface EmployeesService {

    Collection<Employee> getAllEmployees();

    Employee getEmployee(String name);

    void addEmployee(Employee employee);
}
