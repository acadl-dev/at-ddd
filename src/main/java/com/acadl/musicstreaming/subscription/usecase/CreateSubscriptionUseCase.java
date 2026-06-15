package com.acadl.musicstreaming.subscription.usecase;

import com.acadl.musicstreaming.subscription.domain.Subscription;

import java.util.UUID;

public interface CreateSubscriptionUseCase {

    Subscription execute(UUID userId);
}
