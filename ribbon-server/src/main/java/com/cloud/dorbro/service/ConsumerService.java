package com.cloud.dorbro.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ConsumerService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "printServiceFallback")
    public String  printService(){
        return restTemplate.getForEntity("http://test-service/hello", String.class).getBody();
    }

    public String printServiceFallback(){
        return "error";
    }
}
