package com.spring.preparation.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * What can you reference using SpEL?
 * -> static fields and methods
 * -> properties and methods in Spring beans
 * -> properties and methods in Java objects
 * -> (JVM) System properties
 * -> Spring application environment
 */
@Component
public class SpelConfig {

    @Value("#{19+1}")
    public int arithmeticOperation;

    @Value("#{'a'+'b'}")
    public String arithmeticOperationWithStrings;

    @Value("#{30 div 10}")
    public int arithmeticOperationDiv;

    @Value("#{4 == 4}")
    public boolean logicalOperation;

    @Value("#{4 eq 4}")
    public boolean logicalOperation2;

    @Value("#{2 > 1 ? 'a' : 'b'}")
    public char conditionalOperation;

    @Value("#{'100' matches '\\d+'}")
    public boolean matchesOperation;
}
