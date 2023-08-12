
package com.example.demo.src.exception;

import com.example.demo.src.exception.model.CustomException;
import com.example.demo.src.exception.response.ExceptionResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class ExceptionController {

    @ResponseBody
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ExceptionResponse> customExceptionHandler(CustomException e){

        log.info(">>>>>>>>>> exception");

        ExceptionResponse exceptionResponse = ExceptionResponse.builder().validation(e.getValidation()).code(e.getCode()).message(e.getMessage()).build();

        return ResponseEntity.status(e.getCode()).body(exceptionResponse);
    }
}
