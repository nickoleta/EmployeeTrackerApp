package com.spring.boot.preparation.controller;

import com.spring.boot.preparation.dao.EmployeesRepository;
import com.spring.boot.preparation.dto.Employee;
import com.spring.boot.preparation.service.EmployeesService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;

@RunWith(SpringRunner.class)
@WebMvcTest(EmployeesController.class)
@ActiveProfiles("test")
@TestPropertySource("classpath:application-testing.properties")
public class EmployeesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeesService employeesService;

    @MockBean
    private EmployeesRepository employeesRepository;

    @Value("${application.name}")
    private String applicationName;

    @Test
    @WithMockUser(username = "test_user", password = "test_pass")
    public void getEmployee_doesNotExist_notFound() throws Exception {
        Mockito.when(employeesRepository.findAll()).thenReturn(Collections.emptyList());

        mockMvc.perform(MockMvcRequestBuilders.get("/employees/alex"))
                .andExpect(MockMvcResultMatchers.status().is(204));
    }

    @Test
    public void injectionOfTestProperties() {
        Assertions.assertEquals("Spring Professional Certified Exam Preparation", applicationName);
    }

}
