package com.example.demo.src.exception.model;

public class FormException extends CustomException{

    private final static String MESSAGE = "형식 오류입니다.";

    public FormException() {
        super(MESSAGE);
    }
    @Override
    public Integer getCode() {
        return 400;
    }
}
