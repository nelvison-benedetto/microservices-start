package org.lessons.java.springms_start.restcontrollers;
import org.lessons.java.springms_start.constants.AccountCostants;
import org.lessons.java.springms_start.dto.CustomerDTO;
import org.lessons.java.springms_start.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.micrometer.core.ipc.http.HttpSender.Response;

@RestController
@RequestMapping(path ="/api/v1/accounts", produces = {MediaType.APPLICATION_JSON_VALUE}) //mediatype choose 'org-springframework.http'!!
public class AccountRestController {
    
    @PostMapping
    public ResponseEntity<ResponseDTO> createAccount(@RequestBody CustomerDTO customerDTO){
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(new ResponseDTO(AccountCostants.STATUS_201, AccountCostants.MESSAGE_201));
    
    }

}
