package com.spring.preparation.service.impl;

import com.spring.preparation.service.EmployeesService;
import com.spring.preparation.dao.EmployeesDao;
import com.spring.preparation.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service("traineesServiceImpl")
public class TraineesServiceIml implements EmployeesService {

    private final EmployeesDao employeesDao;

    @Autowired
    public TraineesServiceIml(@Qualifier("traineesDaoImpl") EmployeesDao employeesDao) {
        this.employeesDao = employeesDao;
    }

    @Override
    public Collection<Employee> getAllEmployees() {
        return employeesDao.getAllEmployees();
    }

    @Override
    public void addEmployee(Employee employee) {
        employeesDao.addEmployee(employee);
    }

    @Override
    public Employee getEmployee(String name) {
        throw new UnsupportedOperationException("Not implemented functionality!");
    }
}
