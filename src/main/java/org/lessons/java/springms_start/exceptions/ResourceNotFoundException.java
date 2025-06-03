package org.lessons.java.springms_start.exceptions;

public class ResourceNotFoundException extends RuntimeException{  //extends RuntimeException, so this custom can be thrown as a RuntimeException()(thrown from anywhere in the code + try/cath not necessary) 
    
    public ResourceNotFoundException(String resourceName, String fieldName, String fieldValue) {
        super(String.format("%s not found with the given input data %s : '%s'", resourceName, fieldName, fieldValue));  
            //pass the content to the constructor of father RuntimeException, now setted the detailMessage of the father
    }
}
