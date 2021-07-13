package com.spring.boot.preparation.controller;

import com.spring.boot.preparation.dto.Department;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;

@RestController
@RequestMapping("departments")
public class DepartmentsController {

    @GetMapping
    public Collection<Department> getAllDepartments() {
        return Collections.emptyList();
    }
}
