package com.cloud.dogbro.controller;

import com.cloud.dogbro.client.TestServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fegin/")
public class TestController {

    @Autowired
    private TestServiceClient testServiceClient;

    @RequestMapping(value = "hello")
    public String hello(){
       return testServiceClient.hello();
    }
}
