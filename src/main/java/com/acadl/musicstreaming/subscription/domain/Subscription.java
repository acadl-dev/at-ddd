package com.acadl.musicstreaming.subscription.domain;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "subscriptions")
public class Subscription {

    @Id
    @GeneratedValue
    private UUID id;

    private UUID userId;

    private boolean active;

    public Subscription() {
    }

    public Subscription(UUID userId) {
        this.userId = userId;
        this.active = true;
    }

    public void cancel() {
        this.active = false;
    }

    public UUID getId() {
        return id;
    }

    public UUID getUserId() {
        return userId;
    }

    public boolean isActive() {
        return active;
    }
}