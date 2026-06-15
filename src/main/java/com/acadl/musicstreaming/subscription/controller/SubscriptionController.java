package com.acadl.musicstreaming.subscription.controller;

import com.acadl.musicstreaming.subscription.domain.Subscription;
import com.acadl.musicstreaming.subscription.usecase.CreateSubscriptionUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subscriptions")
@RequiredArgsConstructor
public class SubscriptionController {

    private final CreateSubscriptionUseCase useCase;

    @PostMapping
    public Subscription create(
            @RequestBody CreateSubscriptionRequest request
    ) {

        return useCase.execute(
                request.userId()
        );
    }
}