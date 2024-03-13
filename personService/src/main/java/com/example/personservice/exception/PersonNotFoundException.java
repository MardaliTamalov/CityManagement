package com.example.personservice.exception;

import lombok.Getter;

@Getter

public class PersonNotFoundException extends RuntimeException{

    private String massage;
    public PersonNotFoundException(int id) {

        super("житель не найден "+id);
        this.massage= "житель не найден "+id ;
    }
}
