package com.acadl.musicstreaming.account.repository;

import com.acadl.musicstreaming.account.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
