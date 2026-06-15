package com.acadl.musicstreaming.account.controller;
import com.acadl.musicstreaming.account.domain.User;
import com.acadl.musicstreaming.account.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository repository;

    @PostMapping
    public User create(
            @RequestBody CreateUserRequest request
    ) {

        User user = new User(
                null,
                request.name(),
                request.email()
        );

        return repository.save(user);
    }
}
