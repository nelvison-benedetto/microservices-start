package org.lessons.java.springms_start.dto;

import java.util.ArrayList;
import java.util.List;

import org.lessons.java.springms_start.models.Account;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data //fa @getter@setter@ToString@EqualsAndHashCode@RequiredArgsConstructor ma in entita danno problemi equals() e hashcode() x le relzioni bidirezionali!!
public class CustomerDTO {
    
    @NotBlank(message = "firstanme cannot be blank.")
    private String firstName;
    
    @NotBlank(message = "lastname cannot be blank.")
    private String lastName;

    @NotBlank(message = "email cannot be blank.")
    @Email(message = "email invalid.format.")
    private String email;

    @Pattern(regexp = "(^$|[0-9]{10})", message = "phone must be 10 digits.")
    private String phone;

    private List<Account> accounts = new ArrayList();

}
