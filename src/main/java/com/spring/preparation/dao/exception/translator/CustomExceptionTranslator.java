package com.spring.preparation.dao.exception.translator;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.support.SQLExceptionTranslator;

import java.sql.SQLException;

public class CustomExceptionTranslator implements SQLExceptionTranslator {

    @Override
    public DataAccessException translate(String task, String sql, SQLException ex) {
        if(ex.getErrorCode() == 23505) {
            return new DuplicateKeyException("My custom implementation returning DuplicateKeyException if errorCode is equal to 23505");
        }
        return null;
    }
}
