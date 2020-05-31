package com.yoandypv.microservices.resilience4j.service;

import com.yoandypv.microservices.resilience4j.exception.CustomException;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpServerErrorException;

/**
 * In this sample, we are going to simulate call to other microservices, and
 * depend of responses the resilience go to work properly
 */
@Component(value = "ordersDummy")
public class OrdersDummyService implements IService {

    public static final String ORDERS = "ordersDummy";

    @Override
    @CircuitBreaker(name = ORDERS)
    @Bulkhead(name = ORDERS)
    @Retry(name = ORDERS)
    public String success() {
        return "Response HTTP 201 CREATED, order was create successfully";
    }

    @Override
    @CircuitBreaker(name = ORDERS)
    @Bulkhead(name = ORDERS)
    @Retry(name = ORDERS)
    public String failure() {
        throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR, "This is a remote exception for orders service");
    }

    @Override
    @CircuitBreaker(name = ORDERS)
    @Bulkhead(name = ORDERS)
    @Retry(name = ORDERS)
    public String successException() {
        throw new CustomException("This is a remote exception for orders service, but is welcome");
    }

    @Override
    public String timeOut() {
        try {
            Thread.sleep(3500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "Response 200 with slow remote call or method execution";
    }

    @Override
    @CircuitBreaker(name = ORDERS, fallbackMethod = "fallback")
    public String failureWithFallback() {
        return failure();
    }

    private String fallback(HttpServerErrorException ex) {
        return "Response 200, fallback method for error:  " + ex.getMessage();
    }
}
