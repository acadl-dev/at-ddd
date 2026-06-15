package com.acadl.musicstreaming.subscription.service;

import com.acadl.musicstreaming.shared.exception.BusinessException;
import com.acadl.musicstreaming.subscription.repository.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SubscriptionDomainService {

    private final SubscriptionRepository repository;

    public void validateUserHasNoActiveSubscription(
            UUID userId
    ) {

        boolean hasActiveSubscription =
                repository.findByUserIdAndActiveTrue(userId)
                        .isPresent();

        if (hasActiveSubscription) {

            throw new BusinessException(
                    "active-subscription-already-exists"
            );
        }
    }
}