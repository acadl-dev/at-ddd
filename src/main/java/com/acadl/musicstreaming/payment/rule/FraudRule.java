package com.acadl.musicstreaming.payment.rule;

import com.acadl.musicstreaming.payment.domain.Transaction;

public interface FraudRule {

    void validate(Transaction transaction);

}
