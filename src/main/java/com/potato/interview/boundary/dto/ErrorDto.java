package com.potato.interview.boundary.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Schema(title = "Error message")
@AllArgsConstructor
public class ErrorDto {
    String errorType;
    String message;
}
