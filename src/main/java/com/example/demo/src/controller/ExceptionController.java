package com.example.demo.src.controller;

import com.example.demo.src.exception.CustomException;
import com.example.demo.src.exception.response.ExceptionResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionController {

    @ResponseBody
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ExceptionResponse> handleCustomException(CustomException customException){

        ExceptionResponse exceptionResponse = ExceptionResponse.builder()
                .message(customException.getMessage()).code(customException.getCode()).validation(customException.getValidation()).build();

        return ResponseEntity.status(customException.getCode()).body(exceptionResponse);
    }
}
