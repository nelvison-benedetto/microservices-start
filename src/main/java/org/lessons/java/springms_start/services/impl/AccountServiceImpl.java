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
        Customer customer = CustomerMapper.mapToCustomer(customerDTO, new Customer()); //converts obj customerDTO->Customer
        Optional<Customer> optionalCustomer = customerRepo.findByPhone(customerDTO.getPhone());
        if(optionalCustomer.isPresent()){
            throw new CustomerAlreadyExistsException("Customer already registered with given phone "
                + customerDTO.getPhone());
        }

        Customer savedCustomer = customerRepo.save(customer);  //.save() always return the obj just saved
            //to save on DB u need an etity u can't use a DTO, so i converted and now the obj saved had some field null (e.g. field accounts)
        System.out.println("Saved customer from DB: " + customerRepo.findById(savedCustomer.getCustomerId()).get()); //x debug GET DATA FROM THE DB!
        accountRepo.save(createNewAccount(savedCustomer));
    }

    private Account createNewAccount(Customer customer){
        Account newAccount = new Account();
        newAccount.setCustomer(customer);  //x bidirectional relationship
        newAccount.setAccountType(AccountCostants.SAVINGS);
        newAccount.setBranchAddress(AccountCostants.ADDRESS);
        return newAccount;
    }

}
