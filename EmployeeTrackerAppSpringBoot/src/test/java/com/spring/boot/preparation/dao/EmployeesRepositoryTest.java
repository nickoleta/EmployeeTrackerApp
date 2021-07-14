package com.spring.boot.preparation.dao;

import com.spring.boot.preparation.dto.Employee;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeesRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private EmployeesRepository employeesRepository;

    @Before
    public void init() {
        entityManager.persist(new Employee("Tanya", "SENIOR"));
        entityManager.persist(new Employee("Robert", "MID"));
        entityManager.persist(new Employee("Alexander", "PROJECT_MANAGER"));
        entityManager.flush();
    }

    @Test
    public void findByName_existing_ok() {
        final Employee actual = employeesRepository.findEmployeeByName("Robert");

        Assertions.assertEquals("MID", actual.getPosition());
    }

    @Test
    public void findByName_notExisting_null() {
        final Employee actual = employeesRepository.findEmployeeByName("Diana");

        Assertions.assertNull(actual);
    }

}
