package com.acadl.musicstreaming.payment.repository;


import com.acadl.musicstreaming.payment.domain.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CreditCardRepository
        extends JpaRepository<CreditCard, UUID> {

    Optional<CreditCard> findByUserId(
            UUID userId
    );
}
