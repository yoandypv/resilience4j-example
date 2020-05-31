package com.yoandypv.microservices.resilience4j.controller;

import com.yoandypv.microservices.resilience4j.service.OrdersDummyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    @Qualifier("ordersDummy")
    private  OrdersDummyService ordersDummyService;

    @GetMapping("/success")
    public String successOrder(){
        return this.ordersDummyService.success();
    }

    @GetMapping("/failure")
    public String failureOrder(){
        return this.ordersDummyService.failure();
    }

    @GetMapping("/success-exception")
    public String successException(){
        return this.ordersDummyService.successException();
    }

    @GetMapping("/fallback")
    public String fallBack(){
        return this.ordersDummyService.failureWithFallback();
    }

    @GetMapping("/timeout")
    public String timeOutExecution(){
        return this.ordersDummyService.timeOut();
    }




}
