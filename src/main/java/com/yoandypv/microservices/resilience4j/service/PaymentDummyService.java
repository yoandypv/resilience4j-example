package com.yoandypv.microservices.resilience4j.service;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

public class PaymentDummyService implements IService {

    public static final String PAYMENTS = "paymentsDummy";

    @Override
    @CircuitBreaker(name = PAYMENTS)
    @Bulkhead(name = PAYMENTS)
    @Retry(name = PAYMENTS)
    public String success() {
        return null;
    }

    @Override
    public String failure() {
        return null;
    }

    @Override
    public String failureWithFallback() {
        return null;
    }

    @Override
    public String successException() {
        return null;
    }

    @Override
    public String timeOut() {
        return null;
    }
}
