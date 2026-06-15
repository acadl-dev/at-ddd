package com.acadl.musicstreaming.subscription.controller;

import java.util.UUID;

public record CreateSubscriptionRequest(
        UUID userId
) {
}