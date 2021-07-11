package com.spring.preparation.dao.impl;

import com.spring.preparation.dao.EmployeesDao;
import com.spring.preparation.dao.exception.translator.CustomExceptionTranslator;
import com.spring.preparation.dao.mapper.EmployeeRowMapper;
import com.spring.preparation.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

@Repository("employeesDaoImpl")
public class EmployeesDaoImpl implements EmployeesDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public EmployeesDaoImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.jdbcTemplate.setExceptionTranslator(new CustomExceptionTranslator());
    }

    @Override
    public Employee getEmployeeByName(String name) {
        return jdbcTemplate.queryForObject("SELECT * FROM employees WHERE employee_name = ?", new Object[]{ name }, new EmployeeRowMapper());
    }

    @Override
    public Collection<Employee> getAllEmployees() {
        return jdbcTemplate.query("SELECT * FROM employees", new EmployeeRowMapper());
    }

    @Override
    public int addEmployee(Employee employee) {
        return jdbcTemplate.update("INSERT INTO employees VALUES (?, ?)", employee.getName(), employee.getPosition());
    }

    @Override
    public int[] addEmployees(List<Employee> employees) {
        return jdbcTemplate.batchUpdate("INSERT INTO employees VALUES (?, ?)", new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setString(1, employees.get(i).getName());
                ps.setString(2, employees.get(i).getPosition());
            }

            @Override
            public int getBatchSize() {
                return 2;
            }
        });
    }

    @Override
    public int updateEmployeePosition(String name, String position) {
        return jdbcTemplate.update("UPDATE employees SET employee_position = ? WHERE employee_name = ?", position, name);
    }
}
