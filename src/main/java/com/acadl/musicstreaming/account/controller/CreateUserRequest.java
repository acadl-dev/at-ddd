package com.acadl.musicstreaming.account.controller;

public record CreateUserRequest(
        String name,
        String email
) {
}
