package com.acadl.musicstreaming.payment.repository;

import com.acadl.musicstreaming.payment.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface TransactionRepository
        extends JpaRepository<Transaction, UUID> {

    List<Transaction> findByUserIdAndTransactionDateAfter(
            UUID userId,
            LocalDateTime date
    );
}
