package org.lessons.java.springms_start.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CustomerAlreadyExistsException extends RuntimeException{  //add extends RuntimeException!
    public CustomerAlreadyExistsException(String message) {
        super(message);
    }
}
