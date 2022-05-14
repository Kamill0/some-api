package com.potato.interview.control.service;

import com.potato.interview.boundary.dto.CardDto;
import com.potato.interview.boundary.exception.CardNotFoundException;
import com.potato.interview.boundary.exception.UserNotFoundException;
import com.potato.interview.control.repository.CardRepository;
import com.potato.interview.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CardService {

    private final CardRepository cardRepository;
    private final UserService userService;
    public List<CardDto> getAllCards() {
        return cardRepository.findAll()
                .stream()
                .map(EntityMapper::mapToCardDto)
                .collect(Collectors.toList());
    }

    public CardDto getCardById(Long cardId) {
        return cardRepository.findById(cardId).map(EntityMapper::mapToCardDto)
                .orElseThrow(() -> new CardNotFoundException("id = " + cardId));
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

    public void save(CardDto cardDto) {
        String email = cardDto.getUserDto().getEmail();
        try {
            User user = userService.getUserByEmail(email);
            cardRepository.save(EntityMapper.mapToCard(cardDto, user));
        } catch (UserNotFoundException exception) {
            log.error("User of given email: {} was not found, card was not created", email);
            throw exception;
        }
    }
}
