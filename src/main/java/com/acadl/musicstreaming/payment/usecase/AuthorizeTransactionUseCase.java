package com.acadl.musicstreaming.payment.usecase;

import com.acadl.musicstreaming.payment.domain.Transaction;

import java.math.BigDecimal;
import java.util.UUID;

public interface AuthorizeTransactionUseCase {

    Transaction execute(
            UUID userId,
            String merchant,
            BigDecimal amount
    );

}
