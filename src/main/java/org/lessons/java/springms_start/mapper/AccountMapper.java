package org.lessons.java.springms_start.mapper;

import org.lessons.java.springms_start.dto.AccountDTO;
import org.lessons.java.springms_start.models.Account;
import org.lessons.java.springms_start.models.Customer;
import org.lessons.java.springms_start.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountMapper {

    public static AccountDTO mapToAccountDTO(Account account) {  //static! no use Repository within, not necessary create instances
        AccountDTO accountDTO = new AccountDTO();  //better set this directly here, accountDTO isnt saved on db so is always new is customer that is fetched from db

        accountDTO.setAccountId(account.getAccountId());

        accountDTO.setAccountNumber(account.getAccountNumber());
        accountDTO.setAccountType(account.getAccountType());
        accountDTO.setBranchAddress(account.getBranchAddress());

        accountDTO.setCustomerId(account.getCustomer().getCustomerId());

        return accountDTO;
    }

    public static Account mapToAccount(AccountDTO accountDTO, Account account, Customer customer) {  //static! no use Repository within, not necessary create instances
        //account.setAccountId(accountDTO.getAccountId());  //already created in the entity birth
        account.setAccountNumber(accountDTO.getAccountNumber());
        account.setAccountType(accountDTO.getAccountType());
        account.setBranchAddress(accountDTO.getBranchAddress());

        account.setCustomer(customer);

        return account;
    }

}