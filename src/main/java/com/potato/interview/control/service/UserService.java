package com.potato.interview.control.service;

import com.potato.interview.boundary.dto.CardDto;
import com.potato.interview.boundary.exception.UserNotFoundException;
import com.potato.interview.control.repository.CardRepository;
import com.potato.interview.control.repository.UserRepository;
import com.potato.interview.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User getUserById(Long uId) {
        return userRepository.findById(uId).orElseThrow(userNotFound("id = " + uId));
    }

    public User getUserByEmail(String email) {
        return userRepository.findFirstByEmail(email).orElseThrow(userNotFound("email = " + email));
    }

    private Supplier<RuntimeException> userNotFound(String message) {
        return () -> new UserNotFoundException(message);
    }
}
