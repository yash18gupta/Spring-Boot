package com.library.digital.Repository;

import com.library.digital.Entities.Author;
import com.library.digital.Entities.Transaction;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface TransactionRepository extends JpaRepository<Transaction,Integer> {

}
