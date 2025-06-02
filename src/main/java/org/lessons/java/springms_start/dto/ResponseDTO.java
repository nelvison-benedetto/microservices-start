package org.lessons.java.springms_start.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class ResponseDTO {
    
    private String statusCode;
    private String statusMex;

    
}
