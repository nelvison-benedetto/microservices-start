package org.lessons.java.springms_start.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.lessons.java.springms_start.dto.AccountDTO;
import org.lessons.java.springms_start.dto.CustomerDTO;
import org.lessons.java.springms_start.models.Account;
import org.lessons.java.springms_start.models.Customer;

public class CustomerMapper {
    
    public static CustomerDTO mapToCustomerDTO(Customer customer) {  //static! no use Repository within, not necessary create instances
        CustomerDTO customerDTO = new CustomerDTO();  //better set this directly here, customerDTO isnt saved on db so is always new is customer that is fetched from db

        customerDTO.setCustomerId(customer.getCustomerId());

        customerDTO.setFirstName(customer.getFirstName());
        customerDTO.setLastName(customer.getLastName());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setPhone(customer.getPhone());

        List<AccountDTO> accountDTOs = customer.getAccounts().stream()
            .map(account -> {
                AccountDTO dto = new AccountDTO();
                dto.setAccountNumber(account.getAccountNumber());
                dto.setAccountType(account.getAccountType());
                dto.setBranchAddress(account.getBranchAddress());
                dto.setCustomerId(account.getCustomer().getCustomerId());
                return dto;
            })
            .collect(Collectors.toList());
        customerDTO.setAccounts(accountDTOs);

        return customerDTO;
    }


    public static Customer mapToCustomer(CustomerDTO customerDTO, Customer customer) {  //static! no use Repository within, not necessary create instances 
        //customer.setCustomerId(customerDTO.getCustomerId());  //already created in the entity birth
        customer.setFirstName(customerDTO.getFirstName());
        customer.setLastName(customerDTO.getLastName());
        customer.setEmail(customerDTO.getEmail());
        customer.setPhone(customerDTO.getPhone());

        List<Account> accounts = customerDTO.getAccounts().stream()
            .map(dtoAcc -> {
                Account acc = new Account();
                acc.setAccountNumber(dtoAcc.getAccountNumber());
                acc.setAccountType(dtoAcc.getAccountType());
                acc.setBranchAddress(dtoAcc.getBranchAddress());
                acc.setCustomer(customer);  // Imposta il back-reference
                return acc;
            })
            .collect(Collectors.toList());
        customer.setAccounts(accounts);

        return customer;
    }

}
