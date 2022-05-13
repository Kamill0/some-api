package com.potato.interview.boundary;

import com.potato.interview.boundary.dto.CardDto;
import com.potato.interview.boundary.exception.TooManyParamsException;
import com.potato.interview.control.service.CardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/v1", produces = APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Slf4j
public class CardsController {

    private final CardService cardService;

    @GetMapping(path = "/cards", produces = APPLICATION_JSON_VALUE)
    @Operation(description = """
            You can retrieve cards in 3 different ways:
            - provide u_id param in order to seach by user ID 
            - provide u_email to search by email instead
            - omit parameters to return all cards
            """)
    public List<CardDto> getCards(
            @Parameter(in = ParameterIn.QUERY, name = "u_id", description = "ID of an user that owns requested cards", example = "1")
            @RequestParam(value = "u_id", required = false) Long uId,
            @Parameter(in = ParameterIn.QUERY, name = "u_email", description = "Email of an user that owns requested cards", example = "j.smith@email.com")
            @RequestParam(value = "u_email", required = false) String uEmail
    ){
        if (uId != null && uEmail != null) {
            throw new TooManyParamsException("You can either provide user id or user email");
        } else if (uId != null) {
            log.info("Retrieving cards by user id {}", uId);
            return cardService.getCardsByUserId(uId);
        } else if (uEmail != null) {
            log.info("Retrieving cards by user email {}", uEmail);
            return cardService.getCardsByUserEmail(uEmail);
        } else {
            log.info("No parameters specified, retrieving all cards");
            return cardService.getAllCards();
        }
    }
}
