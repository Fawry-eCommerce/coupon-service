package com.fawry.couponservice.exception.CustomExceptionHandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class NotFoundError{
        private String message;
        private final int statusCode= HttpStatus.NOT_FOUND.value();
        private LocalDateTime timestamp;

}
