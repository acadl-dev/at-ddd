package com.acadl.musicstreaming.payment.rule;

import com.acadl.musicstreaming.payment.domain.Transaction;
import com.acadl.musicstreaming.payment.repository.TransactionRepository;
import com.acadl.musicstreaming.shared.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class HighFrequencyRule
        implements FraudRule {

    private final TransactionRepository repository;

    @Override
    public void validate(Transaction transaction) {

        LocalDateTime twoMinutesAgo =
                LocalDateTime.now().minusMinutes(2);

        List<Transaction> transactions =
                repository.findByUserIdAndTransactionDateAfter(
                        transaction.getUserId(),
                        twoMinutesAgo
                );

        if (transactions.size() >= 3) {

            throw new BusinessException(
                    "high-frequency-small-interval"
            );
        }
    }
}

