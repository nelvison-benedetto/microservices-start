package org.lessons.java.springms_start.exceptions;

import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.lessons.java.springms_start.dto.ErrorResponseDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice  //x all controllers
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{  //add ResponseEntityExceptionHandler to set custom response when fail @Validation !
    
    //runned x input @valid not valid
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
    MethodArgumentNotValidException ex,
    HttpHeaders headers,  //from org.springframework.http.HttpHeaders!!
    HttpStatusCode status,  //from org.springframework.http.HttpStatusCode!!
    WebRequest request){
        Map<String, String> validationErrors = new HashMap<>();  //x retrive all info in format key-value
        List<ObjectError> validationErrorList = ex.getBindingResult().getAllErrors();  //extract each validation error (each is a type ObjectError)
        
        validationErrorList.forEach((error) -> {
            String fieldName = ((FieldError) error).getField();  //cast type ObjectError->FieldError to use method getField to know the name
            String validationMex = error.getDefaultMessage();  //get the mex definited in the annotation
            validationErrors.put(fieldName, validationMex);  //add them in the map
        });
        return new ResponseEntity<>(validationErrors, HttpStatus.BAD_REQUEST);
    }



    @ExceptionHandler(CustomerAlreadyExistsException.class)  //intercept (already builded & throwed) CustomerAlreadyExistsException and run this funct
    public ResponseEntity<ErrorResponseDTO> handleCustomerAlreadyException(CustomerAlreadyExistsException exception, WebRequest webRequest){
            //receives the exception + obj webRequest(contains all the info about the http req)
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(
            webRequest.getDescription(false),  //e.g. uri=/api/v1/accounts, false x not include details about the session
                //add .replace("uri=", "") x remove 'uri='
            HttpStatus.BAD_REQUEST,  //code of the error
            exception.getMessage(),  //.getMessage is method of the father, access to the detailMessage of the father
            LocalDateTime.now()  //timestamp
        );  //pass all the values x the constr of ErrorResponseDTO
        return new ResponseEntity<>(errorResponseDTO, HttpStatus.BAD_REQUEST);  //res + 400 Bad Request (richiesta non valida xk dati mancanti ect)
    }

    @ExceptionHandler(ResourceNotFoundException.class)  //intercept (already builded & throwed) ResourceNotFoundException and run this funct
    public ResponseEntity<ErrorResponseDTO> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest webRequest){ 
        //exception is the obj throwed, webRequest obj spring containes info about http req
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(
            webRequest.getDescription(false),
            HttpStatus.NOT_FOUND,
            exception.getMessage(),  //.getMessage is method of the father, access to the detailMessage of the father
            LocalDateTime.now()
        );
        return new ResponseEntity<>(errorResponseDTO, HttpStatus.NOT_FOUND);
    }

    //x generic errors
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> handleGenericException(Exception exception, WebRequest webRequest){
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(
            webRequest.getDescription(false),
            HttpStatus.INTERNAL_SERVER_ERROR,
            exception.getMessage(),  //.getMessage is method of the father, access to the detailMessage of the father
            LocalDateTime.now()
        );
        return new ResponseEntity<>(errorResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
