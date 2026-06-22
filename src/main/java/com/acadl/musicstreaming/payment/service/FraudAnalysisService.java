package com.acadl.musicstreaming.payment.service;

import com.acadl.musicstreaming.payment.domain.Transaction;
import com.acadl.musicstreaming.payment.rule.FraudRule;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FraudAnalysisService {

    private final List<FraudRule> rules;

    public void validate(Transaction transaction) {

        rules.forEach(
                rule -> rule.validate(transaction)
        );
    }
}
