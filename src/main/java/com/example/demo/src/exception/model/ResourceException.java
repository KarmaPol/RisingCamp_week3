package com.example.demo.src.exception.model;

public class ResourceException extends CustomException{

    private final static String MESSAGE = "존재하지 않는 리소스입니다.";

    public ResourceException() {
        super(MESSAGE);
    }

    @Override
    public Integer getCode() {
        return 404;
    }
}
