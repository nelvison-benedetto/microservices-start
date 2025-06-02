package org.lessons.java.springms_start.exceptions;

import java.time.LocalDateTime;

import org.lessons.java.springms_start.dto.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice  //x all controllers
public class GlobalExceptionHandler {
    
    @ExceptionHandler(CustomerAlreadyExistsException.class)  //intercept CustomerAlreadyExistsException sended by controller/service/other
    public ResponseEntity<ErrorResponseDTO> handleCustomerAlreadyException(CustomerAlreadyExistsException exception, WebRequest webRequest){
            //receives the exception + obj webRequest(contains all the info about the http req)
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(
            webRequest.getDescription(false),  //e.g. uri=/api/v1/accounts, false x not include details about the session
                //add .replace("uri=", "") x remove 'uri='
            HttpStatus.BAD_REQUEST,  //code of the error
            exception.getMessage(),
            LocalDateTime.now()  //timestamp
        );  //pass all the values x the constr of ErrorResponseDTO
        return new ResponseEntity<>(errorResponseDTO, HttpStatus.BAD_REQUEST);  //res + 400 Bad Request (richiesta non valida xk dati mancanti ect)
    }

}
