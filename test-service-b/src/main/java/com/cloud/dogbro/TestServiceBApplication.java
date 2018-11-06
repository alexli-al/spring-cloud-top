package com.cloud.dogbro;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class TestServiceBApplication {

    public static  void main(String[] args){
        new SpringApplicationBuilder(TestServiceBApplication.class).web(true).run(args);
    }
}
