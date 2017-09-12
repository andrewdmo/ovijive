package com.ovijive.service;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class InfResponse {

    public enum Status {
        SUCCESS, ERROR
    }

    private String msg;
    private Status status;
    private String operation;
    private Integer input;
    private Integer result;

    // getters and setters here
}