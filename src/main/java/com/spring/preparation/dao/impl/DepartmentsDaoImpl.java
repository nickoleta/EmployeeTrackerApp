package com.spring.preparation.dao.impl;

import com.spring.preparation.dao.DepartmentsDao;
import com.spring.preparation.dao.mapper.DepartmentRowMapper;
import com.spring.preparation.dto.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class DepartmentsDaoImpl implements DepartmentsDao {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public DepartmentsDaoImpl(DataSource dataSource) {
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public String getDepartmentDirector(String departmentName) {
        SqlParameterSource namedParams = new MapSqlParameterSource().addValue("dep_name", departmentName);
        return namedParameterJdbcTemplate.queryForObject("SELECT department_director FROM departments WHERE department_name=:dep_name",
                namedParams, String.class);
    }

    @Override
    public Department getDepartmentByDepartmentName(String departmentName) {
        SqlParameterSource namedParams = new MapSqlParameterSource().addValue("dep_name", departmentName);
        return namedParameterJdbcTemplate.queryForObject("SELECT * FROM departments WHERE department_name=:dep_name",
                namedParams, new DepartmentRowMapper());
    }
}
