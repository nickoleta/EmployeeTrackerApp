package com.spring.preparation.dao.mapper;

import com.spring.preparation.dto.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRowMapper implements RowMapper<Employee> {

    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Employee employee = new Employee();
        employee.setName(rs.getString("employee_name"));
        employee.setPosition(rs.getString("employee_position"));
        return employee;
    }
}
