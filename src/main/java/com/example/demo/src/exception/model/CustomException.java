package com.example.demo.src.exception.model;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public abstract class CustomException extends RuntimeException{
    private final Map<String, String> validation = new HashMap<>();

    public CustomException(String message) {
        super(message);
    }

    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }

    public abstract Integer getCode();

    public void addValidation(String fieldName, String message) {
        validation.put(fieldName, message);
    }
}
