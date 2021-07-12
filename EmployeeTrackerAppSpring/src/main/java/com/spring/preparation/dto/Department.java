package com.spring.preparation.dto;

import lombok.Data;
import lombok.Generated;

@Data
@Generated
public class Department {

    private String name;
    private String director;

    public Department() {
    }

    public Department(String name, String director) {
        this.name = name;
        this.director = director;
    }
}
