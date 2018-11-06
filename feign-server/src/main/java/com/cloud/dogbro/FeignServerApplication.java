package com.cloud.dogbro;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class FeignServerApplication {

    public static void main(String[] args){
        new SpringApplicationBuilder(FeignServerApplication.class).web(true).run(args);
    }
}
