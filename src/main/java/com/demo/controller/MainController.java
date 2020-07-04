package com.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class MainController {
    @GetMapping("")
    public Employee main(@RequestBody @Valid Employee employee) {
        return employee;
    }
}
