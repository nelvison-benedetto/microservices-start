package org.lessons.java.springms_start.dto;

import lombok.Data;

@Data //fa @getter@setter@ToString@EqualsAndHashCode@RequiredArgsConstructor ma in entita danno problemi equals() e hashcode() x le relzioni bidirezionali!!
public class CustomerDTO {
    
    private String firstName;
    private String lastName;

    private String email;
    private String phone;

}
