package com.spring.boot.preparation.exception;

import com.spring.boot.preparation.dto.Department;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DepartmentsExceptionHandler {

    @ExceptionHandler(DepartmentsException.class)
    public ResponseEntity<Department> handleException(Exception exception) {
        if(exception instanceof DepartmentsException) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
