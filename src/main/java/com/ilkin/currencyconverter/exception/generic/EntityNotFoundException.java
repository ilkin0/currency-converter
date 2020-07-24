package com.ilkin.currencyconverter.exception.generic;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends Exception {

    public EntityNotFoundException() {
        super("Entity Not Found");
    }

    public EntityNotFoundException(Class entityClass) {
        super(entityClass.getSimpleName() + " Not Found");
    }

    public EntityNotFoundException(Class entityClass, String code) {
        super(entityClass.getSimpleName() + " Not Found with ID:" + code);
    }

}
