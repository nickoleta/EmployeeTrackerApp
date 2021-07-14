package com.spring.boot.preparation.service.impl;

import com.spring.boot.preparation.dao.EmployeesRepository;
import com.spring.boot.preparation.dto.Employee;
import com.spring.boot.preparation.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class EmployeesServiceImpl implements EmployeesService {

    private EmployeesRepository employeesRepository;

    public EmployeesServiceImpl() {
    }

    @Autowired
    public EmployeesServiceImpl(EmployeesRepository employeesRepository) {
        this.employeesRepository = employeesRepository;
    }

    @Autowired
    public void setEmployeesRepository(EmployeesRepository employeesRepository) {
        this.employeesRepository = employeesRepository;
    }

    @Override
    public Collection<Employee> getAllEmployees() {
        return employeesRepository.findAll();
    }

    @Override
    public Employee getEmployee(String name) {
        return employeesRepository.findEmployeeByName(name);
    }

    @Override
    public void addEmployee(Employee employee) {
        employeesRepository.save(employee);
    }
}
