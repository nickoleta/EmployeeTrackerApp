package com.spring.preparation.dao;

import com.spring.preparation.dto.Department;

import java.util.Collection;
import java.util.List;

public interface DepartmentsDao {

    Collection<Department> getAllDepartments();

    String getDepartmentDirector(String departmentName);

    Department getDepartmentByDepartmentName(String departmentName);

    int[] addAllDepartments(List<Department> departments);
}
