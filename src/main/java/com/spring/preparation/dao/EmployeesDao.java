package com.spring.preparation.dao;

import com.spring.preparation.dto.Employee;

import java.util.Collection;

public interface EmployeesDao {

    Employee getEmployeeByName(String name);

    Collection<Employee> getAllEmployees();

    int addEmployee(Employee employee);

    int updateEmployeePosition(String name, String position);

}
