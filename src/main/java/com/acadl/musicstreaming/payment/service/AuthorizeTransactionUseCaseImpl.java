package com.acadl.musicstreaming.payment.service;

import com.acadl.musicstreaming.payment.domain.Transaction;
import com.acadl.musicstreaming.payment.repository.TransactionRepository;
import com.acadl.musicstreaming.payment.usecase.AuthorizeTransactionUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthorizeTransactionUseCaseImpl
        implements AuthorizeTransactionUseCase {

    private final FraudAnalysisService fraudService;
    private final TransactionRepository repository;

    @Override
    public Transaction execute(
            UUID userId,
            String merchant,
            BigDecimal amount
    ) {

        Transaction transaction =
                new Transaction(
                        userId,
                        merchant,
                        amount
                );

        fraudService.validate(transaction);

        return repository.save(transaction);
    }
}
