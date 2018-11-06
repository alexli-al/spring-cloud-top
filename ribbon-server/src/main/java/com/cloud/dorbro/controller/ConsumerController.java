package com.cloud.dorbro.controller;

import com.cloud.dorbro.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ConsumerService consumerService;


    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(){
            return restTemplate.getForEntity("http://TEST-SERVICE/hello",String.class).getBody();
    }

    //@EnableCircuitBreaker
    @RequestMapping(value = "/testHystrix", method = RequestMethod.GET)
    public String test1(){
        return consumerService.printService();
    }
}
