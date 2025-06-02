package org.lessons.java.springms_start.mapper;

import org.lessons.java.springms_start.dto.CustomerDTO;
import org.lessons.java.springms_start.models.Customer;

public class CustomerMapper {
    
    public static CustomerDTO mapToCustomerDTO(Customer customer, CustomerDTO customerDTO) {
        customerDTO.setFirstName(customer.getFirstName());
        customerDTO.setLastName(customer.getLastName());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setPhone(customer.getPhone());
        return customerDTO;
    }

    public static Customer mapToCustomer(CustomerDTO customerDTO, Customer customer) {
        customer.setFirstName(customerDTO.getFirstName());
        customer.setLastName(customerDTO.getLastName());
        customer.setEmail(customerDTO.getEmail());
        customer.setPhone(customerDTO.getPhone());
        return customer;
    }

}
