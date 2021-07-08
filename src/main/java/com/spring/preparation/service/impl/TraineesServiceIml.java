package com.spring.preparation.service.impl;

import com.spring.preparation.dao.EmployeesDao;
import com.spring.preparation.dto.Employee;
import com.spring.preparation.dto.Position;
import com.spring.preparation.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service("traineesServiceImpl")
public class TraineesServiceIml implements EmployeesService {

    private final EmployeesDao employeesDao;

    @Autowired
    public TraineesServiceIml(EmployeesDao employeesDao) {
        this.employeesDao = employeesDao;
    }

    @Override
    public Collection<Employee> getAllEmployees() {
        return employeesDao.getAllEmployees().stream()
                .filter(employee -> employee.getPosition() == Position.TRAINEE)
                .collect(Collectors.toList());
    }
}
