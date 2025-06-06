package org.lessons.java.springms_start.dto;
import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class ErrorResponseDTO {
    
    private String apiPath;
    private HttpStatus errorCode;
    private String errorMex;
    private LocalDateTime errorTime;

}
