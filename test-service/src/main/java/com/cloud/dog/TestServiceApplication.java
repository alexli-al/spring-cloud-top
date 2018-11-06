package com.cloud.dog;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class TestServiceApplication {
    public static void main(String[] args){
        new SpringApplicationBuilder(TestServiceApplication.class).web(true).run(args);
    }
}
