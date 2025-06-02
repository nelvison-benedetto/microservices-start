package org.lessons.java.springms_start.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)  //if not managed by others, return automatically a 400 Error Bad Request
public class CustomerAlreadyExistsException extends RuntimeException{  //extends RuntimeException, so this custom can be thrown as a RuntimeException()(thrown from anywhere in the code + try/cath not necessary) 
    public CustomerAlreadyExistsException(String message) {
        super(message);  //pass the content to the super class RuntimeException
    }
}
