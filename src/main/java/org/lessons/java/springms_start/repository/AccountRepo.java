package org.lessons.java.springms_start.repository;

import java.util.Optional;

import org.lessons.java.springms_start.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

@Repository
public interface AccountRepo extends JpaRepository<Account, Integer> {
    
    Optional<Account> findByCustomerId(Integer customerId);
    
    @Transactional @Modifying
    void deleteByCustomerId(Integer customerId);
    
}
