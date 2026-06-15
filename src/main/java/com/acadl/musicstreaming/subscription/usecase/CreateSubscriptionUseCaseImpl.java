package com.acadl.musicstreaming.subscription.usecase;

import com.acadl.musicstreaming.subscription.domain.Subscription;
import com.acadl.musicstreaming.subscription.repository.SubscriptionRepository;
import com.acadl.musicstreaming.subscription.service.SubscriptionDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreateSubscriptionUseCaseImpl
        implements CreateSubscriptionUseCase {

    private final SubscriptionRepository repository;

    private final SubscriptionDomainService domainService;

    @Override
    public Subscription execute(UUID userId) {

        domainService
                .validateUserHasNoActiveSubscription(userId);

        Subscription subscription =
                new Subscription(userId);

        return repository.save(subscription);
    }
}