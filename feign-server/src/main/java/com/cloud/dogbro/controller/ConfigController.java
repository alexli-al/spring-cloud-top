package com.cloud.dogbro.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/config")
public class ConfigController {

    @Value("${from}")
    private String from;

    @RequestMapping(value = "/test")
    public String testConfigRepo(){
        return from;
    }
}
