package com.fawry.couponservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private String message;
    private HttpStatus statusCode;
    private LocalDateTime timestamp;
}
