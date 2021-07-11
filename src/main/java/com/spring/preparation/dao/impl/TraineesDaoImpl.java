package com.spring.preparation.dao.impl;

import com.spring.preparation.dao.EmployeesDao;
import com.spring.preparation.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.*;

@Repository("traineesDaoImpl")
public class TraineesDaoImpl implements EmployeesDao {

    private final SimpleJdbcInsert simpleJdbcInsert;

    @Autowired
    public TraineesDaoImpl(DataSource dataSource) {
        this.simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("employees");
    }

    @Override
    public Employee getEmployeeByName(String name) {
        throw new UnsupportedOperationException("Not implemented functionality!");
    }

    @Override
    public Collection<Employee> getAllEmployees() {
        throw new UnsupportedOperationException("Not implemented functionality!");
    }

    @Override
    public int[] addEmployees(List<Employee> employees) {
        return new int[0];
    }

    @Override
    public int addEmployee(Employee employee) {
        Map<String, Object> params = new HashMap<>();
        params.put("employee_name", employee.getName());
        params.put("employee_position", "TRAINEE");
        return simpleJdbcInsert.execute(params);
    }

    @Override
    public int updateEmployeePosition(String name, String position) {
        throw new UnsupportedOperationException("Not implemented functionality!");
    }
}
