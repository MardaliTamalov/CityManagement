package com.example.citymanagement.exceptionHendler;

import com.example.citymanagement.exception.PersonNotFoundException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MainExceptionHendler {
    @ExceptionHandler(PersonNotFoundException.class)
    public ResponseEntity<String> personNotFoundHendler(PersonNotFoundException personNotFoundException) {
        return ResponseEntity.status(HttpStatusCode.valueOf(404)).body(personNotFoundException.getMassage());
    }
}
