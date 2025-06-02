package org.lessons.java.springms_start.exceptions;

import java.time.LocalDateTime;

import org.lessons.java.springms_start.dto.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(CustomerAlreadyExistsException.class)
    public ResponseEntity<ErrorResponseDTO> handleCustomerAlreadyException(CustomerAlreadyExistsException exception, WebRequest webRequest){
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(
            webRequest.getDescription(false),
            HttpStatus.BAD_REQUEST,
            exception.getMessage(),
            LocalDateTime.now()
        );
        return new ResponseEntity<>(errorResponseDTO, HttpStatus.BAD_REQUEST);
    }

}
