package com.potato.interview.boundary.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Data
@With
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Represents object used to create new card")
public class CardCreateDto {

    @Schema(description = "Card number")
    @NotNull
    @Pattern(regexp = "^\\d{16}$", message = "Card number must consist of 16 digits")
    private String number;

    @Schema(description = "Card expiration date")
    @NotNull
    private LocalDate expirationDate;

    @Schema(description = "Card cvv code")
    @NotNull
    private Integer cvv;

    @Schema(description = "Whether the card can be used to make contactless payments")
    @NotNull
    private Boolean isContactless;

    @Schema(description = "Card user email")
    @NotNull
    @Email
    private String userEmail;
}
