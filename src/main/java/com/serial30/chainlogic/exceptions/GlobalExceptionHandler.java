package com.serial30.chainlogic.exceptions;

import com.serial30.chainlogic.pojos.response.MessageResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(FactNotInferredException.class)
    public ResponseEntity<?> factNotInferredException(FactNotInferredException e) {
        var response = new MessageResponse();
        response.setStatus(HttpStatus.NOT_FOUND.value());
        response.setData(e.getMessage());
        response.setMessage("Error occurred!");
        return ResponseEntity.status(response.getStatus()).body(response);
    }
}
