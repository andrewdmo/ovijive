package com.ovijive.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptHandler extends Exception {

    //add URL request query feedback later:
    @ExceptionHandler
    public String error(Exception e) {

        return "error";
    }
}