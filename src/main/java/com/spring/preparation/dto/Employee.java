package com.spring.preparation.dto;

import lombok.Data;
import lombok.Generated;

@Data
@Generated
public class Employee {

    private String name;
    private String position;

    public Employee() {
    }

    public Employee(String name, String position) {
        this.name = name;
        this.position = position;
    }
}
