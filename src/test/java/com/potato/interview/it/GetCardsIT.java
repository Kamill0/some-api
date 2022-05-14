package com.potato.interview.it;

import com.potato.interview.boundary.dto.CardDto;
import com.potato.interview.boundary.dto.UserDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@IntegrationTest
class GetCardsIT {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void getAllCards() {
        // given & when
        CardDto expectedCard = new CardDto()
                .withCvv(123)
                .withNumber("4321456723456512")
                .withExpirationDate(LocalDate.of(2023,1,1))
                .withIsContactless(true);

        UserDto expectedUser = new UserDto()
                .withFirstName("John")
                .withLastName("Smith")
                .withAddress("Krakow, Mogilska st")
                .withEmail("j.smith@email.com");

        ParameterizedTypeReference<List<CardDto>> responseType = new ParameterizedTypeReference<>() {};
        ResponseEntity<List<CardDto>> response = restTemplate.exchange("/v1/cards", HttpMethod.GET, null,  responseType);
        List<CardDto> cards = response.getBody();

        // then
        assertThat(cards).isNotNull().hasSize(1);
        CardDto actualCard = cards.get(0);

        assertThat(actualCard)
                .usingRecursiveComparison()
                .comparingOnlyFields("cvv", "expirationDate", "number", "isContactless")
                .isEqualTo(expectedCard);

        assertThat(actualCard.getUserDto())
                .usingRecursiveComparison()
                .comparingOnlyFields("firstName", "lastName", "address","email")
                .isEqualTo(expectedUser);
    }

}
