package com.potato.interview.boundary.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

import java.time.LocalDate;

@Data
@With
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Represents a single card")
public class CardDto {

    @Schema(description = "Card number")
    private String number;

    @Schema(description = "Card expiration date")
    private LocalDate expirationDate;

    @Schema(description = "Card cvv code")
    private Integer cvv;

    @Schema(description = "Whether the card can be used to make contactless payments")
    private Boolean isContactless;

    @Schema(description = "Card user details")
    private UserDto userDto;
}
