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
public class DuplicateTransactionRule
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

        long count =
                transactions.stream()
                        .filter(t ->
                                t.getMerchant()
                                        .equals(transaction.getMerchant())
                                        &&
                                        t.getAmount()
                                                .compareTo(transaction.getAmount()) == 0
                        )
                        .count();

        if (count >= 2) {

            throw new BusinessException(
                    "doubled-transaction"
            );
        }
    }
}
