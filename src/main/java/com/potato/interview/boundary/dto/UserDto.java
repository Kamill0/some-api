package com.potato.interview.boundary.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

@Data
@With
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Represents card user")
public class UserDto {

    private String firstName;

    private String lastName;

    private String address;

    private String email;
}
