package com.example.demo.src.exception.model;

public class InvalidSigninException extends CustomException{

    private final static String MESSAGE = "잘못된 아이디 혹은 비밀번호 입니다.";

    public InvalidSigninException() {
        super(MESSAGE);
    }

    @Override
    public Integer getCode() {
        return 400;
    }
}
