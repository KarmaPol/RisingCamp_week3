package com.example.demo.src.exception.model;

public class UnauthorizedException extends CustomException{

    private final static String MESSAGE = "인증이 필요합니다.";

    public UnauthorizedException() {
        super(MESSAGE);
    }

    @Override
    public Integer getCode() {
        return 401;
    }
}
