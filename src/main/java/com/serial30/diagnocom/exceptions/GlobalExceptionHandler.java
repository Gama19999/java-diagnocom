package com.serial30.diagnocom.exceptions;

import com.serial30.diagnocom.pojos.response.MessageResponse;
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
        return ResponseEntity.status(response.getStatus()).body(response);
    }
}
