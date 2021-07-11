package com.spring.preparation.dao.impl;

import com.spring.preparation.dao.EmployeesDao;
import com.spring.preparation.dao.mapper.EmployeeRowMapper;
import com.spring.preparation.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collection;

@Repository
public class EmployeesDaoImpl implements EmployeesDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public EmployeesDaoImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Collection<Employee> getAllEmployees() {
        return jdbcTemplate.query("SELECT * FROM employees", new EmployeeRowMapper());
    }
}
