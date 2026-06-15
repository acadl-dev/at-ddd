package com.acadl.musicstreaming.account.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    private String email;
}
