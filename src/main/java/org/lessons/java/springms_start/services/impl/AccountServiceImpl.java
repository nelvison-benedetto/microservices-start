package org.lessons.java.springms_start.services.impl;

import java.util.Optional;
import java.util.Random;

import org.lessons.java.springms_start.constants.AccountCostants;
import org.lessons.java.springms_start.dto.CustomerDTO;
import org.lessons.java.springms_start.exceptions.CustomerAlreadyExistsException;
import org.lessons.java.springms_start.mapper.CustomerMapper;
import org.lessons.java.springms_start.models.Account;
import org.lessons.java.springms_start.models.Customer;
import org.lessons.java.springms_start.repository.AccountRepo;
import org.lessons.java.springms_start.repository.CustomerRepo;
import org.lessons.java.springms_start.services.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
public class AccountServiceImpl implements IAccountService{
    
    private final AccountRepo accountRepo;
    private final CustomerRepo customerRepo;

    @Autowired
    public AccountServiceImpl(AccountRepo accountRepo, CustomerRepo customerRepo) {
        this.accountRepo = accountRepo;
        this.customerRepo = customerRepo;
    }

    @Override
    public void createAccount(CustomerDTO customerDTO) {
        Customer customer = CustomerMapper.mapToCustomer(customerDTO, new Customer());
        Optional<Customer> optionalCustomer = customerRepo.findByPhone(customerDTO.getPhone());
        if(optionalCustomer.isPresent()){
            throw new CustomerAlreadyExistsException("Customer already registeredd with given phone."
                +customerDTO.getPhone());
        }

        Customer savedCustomer = customerRepo.save(customer);
        accountRepo.save(createNewAccount(savedCustomer));
        
    }

    private Account createNewAccount(Customer customer){
        Account newAccount = new Account();
        newAccount.setCustomer(customer);
        Integer randomAccNumber = 100000L + new Random().nextInt(9000000);
    
        newAccount.setAccounts(randomAccNumber);
        newAccount.setAccountType(AccountCostants.SAVINGS);
        newAccount.setBranchAddress(AccountCostants.ADDRESS);
        return newAccount;
    }

}
