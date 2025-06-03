package org.lessons.java.springms_start.dto;
import java.util.List;
import org.lessons.java.springms_start.models.Account;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// @Getter @Setter @NoArgsConstructor
// @AllArgsConstructor
@Data //fa @getter@setter@ToString@EqualsAndHashCode@RequiredArgsConstructor ma in entita danno problemi equals() e hashcode() x le relzioni bidirezionali!!
public class AccountDTO {

    private Integer accountId;
    
    @NotBlank(message = "accountNumber cannot be blank.")
    @Pattern(regexp = "^[0-9]{10}$", message = "accountNumber must be 10 digits.")
    private String accountNumber;

    @NotBlank(message = "accountType cannot be blank.")
    private String accountType;

    @NotBlank(message = "branchAddress cannot be blank.")
    private String branchAddress;

    private Integer customerId;  //custom SOLO ID, x evitare loop relazione infiniti fra i 2 dto.

}
