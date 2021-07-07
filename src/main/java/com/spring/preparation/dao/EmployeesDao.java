package com.spring.preparation.dao;

import com.spring.preparation.dto.Employee;

import java.util.Collection;

public interface EmployeesDao {

    Collection<Employee> getAllEmployees();
}
