package org.lessons.java.springms_start.repository;

import java.util.List;
import java.util.Optional;

import org.lessons.java.springms_start.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

@Repository
public interface AccountRepo extends JpaRepository<Account, Integer> {
    
    List<Account> findByCustomer_CustomerId(Integer customerId);
    
    @Transactional  //spring knows all operations will be performed within a Transaction(if operation fails, the transaction is rolled back (annullata) easily)
    @Modifying  //spring knows that is operation of modifying, otherwise only read is performed
    void deleteByCustomer_CustomerId(Integer customerId);
    
}
