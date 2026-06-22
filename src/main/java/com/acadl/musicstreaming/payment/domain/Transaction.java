package com.acadl.musicstreaming.payment.domain;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;


@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue
    private UUID id;

    private UUID userId;

    private String merchant;

    private BigDecimal amount;

    private LocalDateTime transactionDate;

    protected Transaction() {
    }

    public Transaction(
            UUID userId,
            String merchant,
            BigDecimal amount
    ) {
        this.userId = userId;
        this.merchant = merchant;
        this.amount = amount;
        this.transactionDate = LocalDateTime.now();
    }

    public UUID getUserId() {
        return userId;
    }

    public String getMerchant() {
        return merchant;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }
}
