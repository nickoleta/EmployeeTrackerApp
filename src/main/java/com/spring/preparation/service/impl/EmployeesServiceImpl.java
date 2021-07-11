package com.spring.preparation.service.impl;

import com.spring.preparation.dao.EmployeesDao;
import com.spring.preparation.dto.Employee;
import com.spring.preparation.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service("employeesServiceImpl")
public class EmployeesServiceImpl implements EmployeesService {

    private final EmployeesDao employeesDao;

    @Autowired
    public EmployeesServiceImpl(@Qualifier("employeesDaoImpl") EmployeesDao employeesDao) {
        this.employeesDao = employeesDao;
    }

    @Override
    public Collection<Employee> getAllEmployees() {
        return employeesDao.getAllEmployees();
    }
}
