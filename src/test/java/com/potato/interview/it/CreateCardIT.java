package com.potato.interview.it;

import com.potato.interview.boundary.dto.CardCreateDto;
import com.potato.interview.control.repository.CardRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@IntegrationTest
class CreateCardIT {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private CardRepository cardRepository;

    @Test
    void createCard() {
        // given & when
        CardCreateDto cardCreateDto = new CardCreateDto()
                .withCvv(456)
                .withNumber("1234567812345678")
                .withExpirationDate(LocalDate.of(2024,12,12))
                .withIsContactless(false)
                .withUserEmail("a.kowalski@email.com");

        HttpEntity<CardCreateDto> request = new HttpEntity<>(cardCreateDto);
        ResponseEntity<String> response = restTemplate
                .exchange("/v1/cards", HttpMethod.POST, request, String.class);

        // then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(cardRepository.findAll()).hasSize(2);
    }
}
