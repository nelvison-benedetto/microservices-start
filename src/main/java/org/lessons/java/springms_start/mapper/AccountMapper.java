package org.lessons.java.springms_start.mapper;

import org.lessons.java.springms_start.dto.AccountDTO;
import org.lessons.java.springms_start.models.Account;

public class AccountMapper {
    
    public static AccountDTO mapToAccountDTO(Account account, AccountDTO accountDTO) { //AccountDTO accountDTO
        accountDTO.setAccounts(account.getAccounts());
        accountDTO.setAccountType(account.getAccountType());
        accountDTO.setBranchAddress(account.getBranchAddress());
        return accountDTO;
    }

    public static Account mapToAccount(AccountDTO accountDTO, Account account) {
        account.setAccounts(accountDTO.getAccounts());
        account.setAccountType(accountDTO.getAccountType());
        account.setBranchAddress(accountDTO.getBranchAddress());
        return account;
    }

}