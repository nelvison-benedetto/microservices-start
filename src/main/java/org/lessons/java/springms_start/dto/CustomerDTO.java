package org.lessons.java.springms_start.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data //fa @getter@setter@ToString@EqualsAndHashCode@RequiredArgsConstructor ma in entita danno problemi equals() e hashcode() x le relzioni bidirezionali!!
public class CustomerDTO {
    
    @NotEmpty(message = "firstanme cannot be null.")
    private String firstName;
    
    @NotEmpty(message = "lastname cannot be null.")
    private String lastName;

    @NotEmpty(message = "email cannot be null.")
    @Email(message = "email invalid.format.")
    private String email;

    @Pattern(regexp = "(^$|[0-9]{10})", message = "phone must be 10 digits.")
    private String phone;

    private AccountDTO accountDTO;

}
