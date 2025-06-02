package org.lessons.java.springms_start.services;

import org.lessons.java.springms_start.dto.CustomerDTO;

public interface IAccountService {

    void createAccount(CustomerDTO customerDTO);  //this method must be implemented x who implements this interface IAccountService

    CustomerDTO fetchAccount(String phone);

    boolean updateAccount(CustomerDTO customerDTO);

    boolean deleteAccount(String phone);

}
