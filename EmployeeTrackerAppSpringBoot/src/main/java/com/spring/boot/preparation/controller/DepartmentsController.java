package com.spring.boot.preparation.controller;

import com.spring.boot.preparation.config.ConfigurationPropertiesTest;
import com.spring.boot.preparation.dto.Department;
import com.spring.boot.preparation.exception.DepartmentsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

//@RestController
//@RequestMapping("/departments")
public class DepartmentsController {

    @Autowired
    private ConfigurationPropertiesTest configurationProperties;

    @GetMapping
    public Collection<Department> getAllDepartments() {
        return List.of(new Department(configurationProperties.getUsername(), configurationProperties.getUsername()));
//        throw new DepartmentsException();
    }
}
