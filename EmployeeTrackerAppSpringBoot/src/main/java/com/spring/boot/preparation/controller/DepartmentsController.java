package com.spring.boot.preparation.controller;

import com.spring.boot.preparation.dto.Department;
import com.spring.boot.preparation.exception.DepartmentsException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("departments")
public class DepartmentsController {

    @GetMapping
    public Collection<Department> getAllDepartments() {
        throw new DepartmentsException();
    }
}
