package org.lessons.java.springms_start.dto;
import java.util.List;
import org.lessons.java.springms_start.models.Account;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// @Getter @Setter @NoArgsConstructor
// @AllArgsConstructor
@Data //fa @getter@setter@ToString@EqualsAndHashCode@RequiredArgsConstructor ma in entita danno problemi equals() e hashcode() x le relzioni bidirezionali!!
public class AccountDTO {
    
    @NotEmpty(message = "accountId cannot be null.")
    private Integer accountId;   //!!!maybe should be "accountNumber" and apply a @Pattern(regexp = "(^$|[0-9]{10})", message = "accountNumber must be 10 digits.")

    @NotEmpty(message = "accountType cannot be null.")
    private String accountType;

    @NotEmpty(message = "branchAddress cannot be null.")
    private String branchAddress;

    //private CustomerDTO customer;

}
