package com.example.jpa.controller;

import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ ObjectOptimisticLockingFailureException.class, OptimisticLockingFailureException.class })
    public ResponseEntity<String> handleOptimisticLocking(Exception ex) {
        String body = "Conflict: the record was updated or deleted by another transaction. Please refresh and retry.";
        return ResponseEntity.status(HttpStatus.CONFLICT).body(body + " Details: " + ex.getMessage());
    }

}
