package com.example.demo.src.exception.response;

import lombok.Builder;

import java.util.Map;

public class ExceptionResponse {
    private final String message;
    private final Integer code;
    private Map<String,String> validation;

    @Builder
    public ExceptionResponse(String message, Integer code, Map<String, String> validation) {
        this.message = message;
        this.code = code;
        this.validation = validation;
    }

    public void addValidation(String field, String message){
        this.validation.put(field, message);
    }
}
