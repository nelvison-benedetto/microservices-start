package org.lessons.java.springms_start.exceptions;

import java.lang.reflect.Method;
import java.net.http.HttpHeaders;
import java.time.LocalDateTime;

import org.lessons.java.springms_start.dto.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice  //x all controllers
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{  //add ResponseEntityExceptionHandler to set custom response when fail @Validation !
    
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
    MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request){
        Map<String, String> validationErrors = new HashMap<>();
        List<ObjectError> validationErrorList = ex.getBindingResult().getAllErrors();
        
        validationErrorList.forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String validationMex = error.getDefaultMessage();
            validationErrors.put(fieldName, validationMex);
        });
        
        return new ResponseEntity<>(validationErrors, HttpStatus.BAD_REQUEST);
    }


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

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest webRequest){
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(
            webRequest.getDescription(false),
            HttpStatus.NOT_FOUND,
            exception.getMessage(),
            LocalDateTime.now()
        );
        return new ResponseEntity<>(errorResponseDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> handleGenericException(Exception exception, WebRequest webRequest){
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(
            webRequest.getDescription(false),
            HttpStatus.INTERNAL_SERVER_ERROR,
            exception.getMessage(),
            LocalDateTime.now()
        );
        return new ResponseEntity<>(errorResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
