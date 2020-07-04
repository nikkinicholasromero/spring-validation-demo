package com.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.Positive;

@RestController
@Validated
public class MainController {
    @GetMapping("")
    public Employee main(@RequestBody @Valid Employee employee) {
        return employee;
    }

    @GetMapping("/withPathVariable/{id}")
    public int withPathVariable(@PathVariable("id") @Positive int id) {
        return id;
    }

    @GetMapping("/withRequestParam")
    public int withRequestParam(@RequestParam("id") @Positive int id) {
        return id;
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e) {
        return new ResponseEntity<>("not valid due to validation error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
