package com.yoandypv.microservices.resilience4j.exception;

public class CustomException extends RuntimeException {

    public CustomException(String message) {
        super(message);
    }
}
