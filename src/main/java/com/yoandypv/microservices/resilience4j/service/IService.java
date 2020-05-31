package com.yoandypv.microservices.resilience4j.service;

public interface IService {
    String success();
    String failure();
    String failureWithFallback();
    String successException();
    String timeOut();
}
