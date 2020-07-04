package com.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(MainController.class)
public class MainControllerTest {
    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    private Employee employee;

    @BeforeEach
    public void setup() {
        objectMapper = new ObjectMapper();

        employee = new Employee();
        employee.setId(1);
        employee.setFirstName("Nikki Nicholas");
        employee.setMiddleName("Domingo");
        employee.setLastName("Romero");
        employee.setSalary(15000);
        employee.setSomeDate(LocalDate.of(2020, 7, 4));
        employee.setSomeTime(LocalTime.of(10, 26));
        employee.setSomeDatetime(LocalDateTime.of(2020, 7, 4, 10, 26));
        employee.setEmail("nikkinicholas.romero@gmail.com");
        employee.setPhoneNumber("28765432");
        employee.setMobileNumber("639901234567");
        employee.setActive(true);
    }

    @Test
    public void whenValidRequestObject() throws Exception {
        mockMvc.perform(get("")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(employee)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("id", is(1)))
                .andExpect(jsonPath("firstName", is("Nikki Nicholas")))
                .andExpect(jsonPath("middleName", is("Domingo")))
                .andExpect(jsonPath("lastName", is("Romero")))
                .andExpect(jsonPath("salary", is(15000.0)))
                .andExpect(jsonPath("someDate", is("2020-07-04")))
                .andExpect(jsonPath("someTime", is("10:26:00")))
                .andExpect(jsonPath("someDatetime", is("2020-07-04T10:26:00")))
                .andExpect(jsonPath("email", is("nikkinicholas.romero@gmail.com")))
                .andExpect(jsonPath("phoneNumber", is("28765432")))
                .andExpect(jsonPath("mobileNumber", is("639901234567")))
                .andExpect(jsonPath("active", is(true)));
    }

    @Test
    public void whenIdIsNegative() throws Exception {
        employee.setId(-1);

        mockMvc.perform(get("")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(employee)))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void whenIdIsZero() throws Exception {
        employee.setId(0);

        mockMvc.perform(get("")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(employee)))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void whenFirstNameIsNull() throws Exception {
        employee.setFirstName(null);

        mockMvc.perform(get("")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(employee)))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void whenFirstNameIsEmpty() throws Exception {
        employee.setFirstName("");

        mockMvc.perform(get("")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(employee)))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void whenMiddleNameIsNull() throws Exception {
        employee.setMiddleName(null);

        mockMvc.perform(get("")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(employee)))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void whenMiddleNameIsEmpty() throws Exception {
        employee.setMiddleName("");

        mockMvc.perform(get("")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(employee)))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void whenLastNameIsNull() throws Exception {
        employee.setLastName(null);

        mockMvc.perform(get("")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(employee)))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void whenLastNameIsEmpty() throws Exception {
        employee.setLastName("");

        mockMvc.perform(get("")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(employee)))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void whenSalaryIsNegative() throws Exception {
        employee.setSalary(-1);

        mockMvc.perform(get("")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(employee)))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void whenSalaryIsZero() throws Exception {
        employee.setSalary(0);

        mockMvc.perform(get("")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(employee)))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void whenSomeDateIsNull() throws Exception {
        employee.setSomeDate(null);

        mockMvc.perform(get("")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(employee)))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void whenSomeTimeIsNull() throws Exception {
        employee.setSomeTime(null);

        mockMvc.perform(get("")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(employee)))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void whenSomeDateTimeIsNull() throws Exception {
        employee.setSomeDatetime(null);

        mockMvc.perform(get("")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(employee)))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void whenEmailIsNull() throws Exception {
        employee.setEmail(null);

        mockMvc.perform(get("")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(employee)))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void whenEmailIsBlank() throws Exception {
        employee.setEmail("");

        mockMvc.perform(get("")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(employee)))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void whenEmailIsInvalid() throws Exception {
        employee.setEmail("@@@@asd");

        mockMvc.perform(get("")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(employee)))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void whenPhoneNumberIsInvalid() throws Exception {
        employee.setPhoneNumber("01234567");

        mockMvc.perform(get("")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(employee)))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void whenMobileNumberIsInvalid() throws Exception {
        employee.setMobileNumber("630901234567");

        mockMvc.perform(get("")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(employee)))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
}
