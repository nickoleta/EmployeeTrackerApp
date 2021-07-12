package com.spring.boot.preparation.dao;

import com.spring.boot.preparation.dto.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeesRepository extends JpaRepository<Employee, String> {

    Employee findEmployeeByName(String name);
}
