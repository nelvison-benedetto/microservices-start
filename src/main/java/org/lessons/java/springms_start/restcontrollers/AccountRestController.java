package org.lessons.java.springms_start.restcontrollers;
import org.lessons.java.springms_start.constants.AccountCostants;
import org.lessons.java.springms_start.dto.CustomerDTO;
import org.lessons.java.springms_start.dto.ResponseDTO;
import org.lessons.java.springms_start.services.IAccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.micrometer.core.ipc.http.HttpSender.Response;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path ="/api/v1/accounts", produces = {MediaType.APPLICATION_JSON_VALUE}) //mediatype choose 'org-springframework.http', the controller ALWAYS returns json
@Validated //APPLY VALIDATION TO ALL THE ENDPOINTS!!!
public class AccountRestController {
    
    private final IAccountService iAccountService;
    public AccountRestController(IAccountService iAccountService){
        this.iAccountService = iAccountService;
    }

    @PostMapping
    public ResponseEntity<ResponseDTO> createAccount(@Valid @RequestBody CustomerDTO customerDTO){
        iAccountService.createAccount(customerDTO);  //use the interface, so in future u can change the implementation without edit anything here
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(new ResponseDTO(AccountCostants.STATUS_201, AccountCostants.MESSAGE_201));
    }

    @GetMapping("/fetch")
    public ResponseEntity<CustomerDTO> fetchAccountDetails(@RequestParam
    @Pattern(regexp = "(^$|[0-9]{10})", message = "phone must be 10 digits.")
    String phone){
        CustomerDTO customerDTO = iAccountService.fetchAccount(phone);
        return ResponseEntity.status(HttpStatus.OK).body(customerDTO);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDTO> updateAccountDetails(@Valid @RequestBody CustomerDTO customerDTO){
        boolean isUpdated = iAccountService.updateAccount(customerDTO);
        if(isUpdated){
            return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDTO(AccountCostants.STATUS_200, AccountCostants.MESSAGE_200));
        }else{
            return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ResponseDTO(AccountCostants.STATUS_500, AccountCostants.MESSAGE_500));
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDTO> deleteAccountDetails(@RequestParam
    @Pattern(regexp = "(^$|[0-9]{10})", message = "phone must be 10 digits.")
    String phone){
        boolean isDeleted = iAccountService.deleteAccount(phone);
        if(isDeleted){
            return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDTO(AccountCostants.STATUS_200, AccountCostants.MESSAGE_200));
        }else{
            return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ResponseDTO(AccountCostants.STATUS_500, AccountCostants.MESSAGE_500));
        }
    }


}
