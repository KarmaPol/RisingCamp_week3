package com.example.demo.src.exception;

import com.example.demo.src.exception.model.CustomException;
import com.example.demo.src.exception.response.ExceptionResponse;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionController {

    @ResponseBody
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ExceptionResponse> customExceptionHandler(CustomException e){

        ExceptionResponse exceptionResponse = ExceptionResponse.builder().validation(e.getValidation()).code(e.getCode()).message(e.getMessage()).build();

        ResponseEntity<ExceptionResponse> responseEntity = ResponseEntity.status(e.getCode()).body(exceptionResponse);

        return responseEntity;
    }
}
