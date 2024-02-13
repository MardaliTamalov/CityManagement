package com.example.citymanagement.exception;

import lombok.Getter;
import lombok.Setter;

@Getter

public class PersonNotFoundException extends RuntimeException{

    private String massage;
    public PersonNotFoundException(int id) {

        super("житель не найден "+id);
        this.massage= "житель не найден "+id ;
    }
}
