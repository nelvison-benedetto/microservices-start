package org.lessons.java.springms_start.repository;

import org.lessons.java.springms_start.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepo extends JpaRepository<Account, Integer> {
    
}
