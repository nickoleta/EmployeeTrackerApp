package com.spring.preparation.dao.impl;

import com.spring.preparation.dao.EmployeesDao;
import com.spring.preparation.dto.Employee;
import com.spring.preparation.dto.Position;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public class EmployeesDaoImpl implements EmployeesDao {

    @Override
    public Collection<Employee> getAllEmployees() {
        return List.of(new Employee("Alex", Position.TRAINEE),
                new Employee("Nicole", Position.TRAINEE),
                new Employee("Daniel", Position.JUNIOR),
                new Employee("Alexander", Position.MID),
                new Employee("Becky", Position.MID),
                new Employee("Diana", Position.SENIOR),
                new Employee("Jack", Position.SENIOR),
                new Employee("John", Position.PROJECT_MANAGER),
                new Employee("Andy", Position.CEO));
    }
}
