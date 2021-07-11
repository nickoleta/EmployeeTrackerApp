package com.spring.preparation.dao.mapper;

import com.spring.preparation.dto.Department;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartmentRowMapper implements RowMapper<Department> {

    @Override
    public Department mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Department department = new Department();
        department.setName(rs.getString("department_name"));
        department.setDirector(rs.getString("department_director"));
        return department;
    }
}
