package com.example.demo.src.exception.model;

public class NameDuplicateException extends CustomException{

    private final static String MESSAGE = "이메일이 중복되었습니다.";

    public NameDuplicateException() {
        super(MESSAGE);
    }
    @Override
    public Integer getCode() {
        return 400;
    }
}
