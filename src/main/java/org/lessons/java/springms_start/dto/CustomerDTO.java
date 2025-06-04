package org.lessons.java.springms_start.dto;

import java.util.ArrayList;
import java.util.List;

import org.lessons.java.springms_start.models.Account;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data //fa @getter@setter@ToString@EqualsAndHashCode@RequiredArgsConstructor ma in entita danno problemi equals() e hashcode() x le relzioni bidirezionali!!
@Schema(
    name = "Customer",
    description = "Schema to hold CustomerDTO and his accounts (in list type AccountDTO).",
    requiredProperties = {"firstName", "lastName", "email", "phone"}
)
public class CustomerDTO {
    
    private Integer customerId;

    @Schema(description = "Customer's first name.", example = "Jains")  //x info debug rest api
    @NotBlank(message = "firstanme cannot be blank.")
    private String firstName;
    
    @Schema(description = "Customer's last name.")  //x info debug rest api
    @NotBlank(message = "lastname cannot be blank.")
    private String lastName;

    @NotBlank(message = "email cannot be blank.")
    @Email(message = "email invalid.format.")
    private String email;

    @Pattern(regexp = "^[0-9]{10}$", message = "phone must be 10 digits.")
    private String phone;

    private List<AccountDTO> accounts = new ArrayList<AccountDTO>(); //specific the type w <AccountDTO> | '<>' x avoid raw types

}
