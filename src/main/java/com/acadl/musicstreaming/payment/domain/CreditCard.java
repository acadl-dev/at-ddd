package com.acadl.musicstreaming.payment.domain;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "credit_cards")
public class CreditCard {
    @Id
    @GeneratedValue
    private UUID id;

    private UUID userId;

    private String cardNumber;

    private boolean active;

    protected CreditCard() {
    }

    public CreditCard(
            UUID userId,
            String cardNumber,
            boolean active
    ) {
        this.userId = userId;
        this.cardNumber = cardNumber;
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }

    public UUID getUserId() {
        return userId;
    }
}
