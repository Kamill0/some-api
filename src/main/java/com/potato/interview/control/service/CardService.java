package com.potato.interview.control.service;

import com.potato.interview.boundary.dto.CardDto;
import com.potato.interview.control.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CardService {

    private final CardRepository cardRepository;
    private final UserService userService;
    public List<CardDto> getAllCards() {
        return cardRepository.findAll()
                .stream()
                .map(EntityMapper::mapToCardDto)
                .collect(Collectors.toList());
    }
    public List<CardDto> getCardsByUserId(Long uId) {
        return cardRepository.findAllByUser(userService.getUserById(uId))
                .stream()
                .map(EntityMapper::mapToCardDto)
                .collect(Collectors.toList());
    }
    public List<CardDto> getCardsByUserEmail(String uEmail) {
        return cardRepository.findAllByUser(userService.getUserByEmail(uEmail))
                .stream()
                .map(EntityMapper::mapToCardDto)
                .collect(Collectors.toList());
    }
}
