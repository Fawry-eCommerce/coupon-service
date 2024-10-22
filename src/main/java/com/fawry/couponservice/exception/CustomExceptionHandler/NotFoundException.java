package com.fawry.couponservice.exception.CustomExceptionHandler;

public class NotFoundException extends  RuntimeException {

    public NotFoundException(String message) {
        super(message);
    }
}
