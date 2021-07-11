package com.spring.preparation.dao;

import com.spring.preparation.dto.Department;

public interface DepartmentsDao {

    String getDepartmentDirector(String departmentName);

    Department getDepartmentByDepartmentName(String departmentName);
}
