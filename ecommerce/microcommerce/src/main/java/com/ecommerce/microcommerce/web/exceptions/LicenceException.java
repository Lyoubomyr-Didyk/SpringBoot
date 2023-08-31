package com.ecommerce.microcommerce.web.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;


@ResponseStatus(HttpStatus.NOT_FOUND)
public class LicenceException extends ResponseStatusException {
    public LicenceException (String s) {
        super(HttpStatus.BAD_REQUEST, s);
    }
}