package org.lessons.java.springms_start.dto;
import java.util.List;
import org.lessons.java.springms_start.models.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// @Getter @Setter @NoArgsConstructor
// @AllArgsConstructor
@Data //fa @getter@setter@ToString@EqualsAndHashCode@RequiredArgsConstructor ma in entita danno problemi equals() e hashcode() x le relzioni bidirezionali!!
public class AccountDTO {
    
    private List<Account> accounts;
    private String accountType;
    private String branchAddress;

}
