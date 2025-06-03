package org.lessons.java.springms_start.mapper;

import org.lessons.java.springms_start.dto.AccountDTO;
import org.lessons.java.springms_start.models.Account;

public class AccountMapper {
    
    public static AccountDTO mapToAccountDTO(Account account, AccountDTO accountDTO) {  //static! not necessary create instances

        accountDTO.setAccountNumber(account.getAccountNumber());
        accountDTO.setAccountType(account.getAccountType());
        accountDTO.setBranchAddress(account.getBranchAddress());
        return accountDTO;  //return the obj setted correctly
    }

    public static Account mapToAccount(AccountDTO accountDTO, Account account) {  //static! not necessary create instances

        accountDTO.setAccountNumber(account.getAccountNumber());
        account.setAccountType(accountDTO.getAccountType());
        account.setBranchAddress(accountDTO.getBranchAddress());
        return account;   //return the obj setted correctly
    }

}