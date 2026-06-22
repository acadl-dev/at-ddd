package com.acadl.musicstreaming.payment.controller;

import com.acadl.musicstreaming.payment.domain.Transaction;
import com.acadl.musicstreaming.payment.usecase.AuthorizeTransactionUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final AuthorizeTransactionUseCase useCase;

    @PostMapping
    public Transaction create(
            @RequestBody TransactionRequest request
    ) {

        return useCase.execute(
                request.userId(),
                request.merchant(),
                request.amount()
        );
    }
}
