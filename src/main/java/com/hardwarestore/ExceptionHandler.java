package com.hardwarestore;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class ExceptionHandler {

    @RequiredArgsConstructor
    @Getter
    public final static class ErrorModel {
        private final String errorMessage;
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorModel> handleIllegalArgument(IllegalArgumentException exception) {
        return new ResponseEntity<>(new ErrorModel(exception.getLocalizedMessage()), HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorModel> handleIllegalArgument(NullPointerException exception) {
        return new ResponseEntity<>(new ErrorModel(
                "Все поля в запросе должны иметь значение, отличное от null"), HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorModel> handleIllegalArgument(ConstraintViolationException exception) {
        return new ResponseEntity<>(new ErrorModel(
                "Все поля в запросе должны иметь значение, отличное от null"), HttpStatus.BAD_REQUEST);
    }
}