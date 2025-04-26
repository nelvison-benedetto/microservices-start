package org.lessons.java.springms_start.repository;

import org.lessons.java.springms_start.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer>{
    
}
