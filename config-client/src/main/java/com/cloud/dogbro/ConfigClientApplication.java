package com.cloud.dogbro;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ConfigClientApplication {
    public static void main(String[] args){
        new SpringApplicationBuilder(ConfigClientApplication.class).web(true).run(args);
    }
}
