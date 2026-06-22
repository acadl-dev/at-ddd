package com.acadl.musicstreaming.payment.rule;

import com.acadl.musicstreaming.payment.domain.CreditCard;
import com.acadl.musicstreaming.payment.domain.Transaction;
import com.acadl.musicstreaming.payment.repository.CreditCardRepository;
import com.acadl.musicstreaming.shared.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CardActiveRule
        implements FraudRule {

    private final CreditCardRepository repository;

    @Override
    public void validate(Transaction transaction) {

        CreditCard card =
                repository.findByUserId(
                        transaction.getUserId()
                ).orElseThrow();

        if (!card.isActive()) {

            throw new BusinessException(
                    "card-not-active"
            );
        }
    }
}
