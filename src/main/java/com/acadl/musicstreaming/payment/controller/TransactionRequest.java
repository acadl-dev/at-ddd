package com.acadl.musicstreaming.payment.controller;

import java.math.BigDecimal;
import java.util.UUID;

public record TransactionRequest(
        UUID userId,
        String merchant,
        BigDecimal amount
) {
}