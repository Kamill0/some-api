package com.potato.interview.control.service;

import com.potato.interview.boundary.dto.CardCreateDto;
import com.potato.interview.boundary.dto.CardDto;
import com.potato.interview.boundary.dto.UserDto;
import com.potato.interview.entity.Card;
import com.potato.interview.entity.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class EntityMapper {
    public static CardDto mapToCardDto(Card card) {
        return new CardDto()
                .withId(card.getId())
                .withNumber(card.getNumber())
                .withCvv(card.getCvv())
                .withExpirationDate(card.getExpirationDate())
                .withIsContactless(card.getIsContactless())
                .withUserDto(mapToUserDto(card.getUser()));
    }

    public static Card mapToCard(CardCreateDto cardCreateDto, User user) {
        Card card = new Card();
        card.setCvv(cardCreateDto.getCvv());
        card.setNumber(cardCreateDto.getNumber());
        card.setExpirationDate(cardCreateDto.getExpirationDate());
        card.setIsContactless(cardCreateDto.getIsContactless());
        card.setUser(user);
        return card;
    }
    public static UserDto mapToUserDto(User user) {
        return new UserDto()
                .withFirstName(user.getFirstName())
                .withLastName(user.getLastName())
                .withAddress(user.getAddress())
                .withEmail(user.getEmail());
    }
}
