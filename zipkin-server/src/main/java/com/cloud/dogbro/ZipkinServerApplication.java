package com.cloud.dogbro;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import zipkin.server.EnableZipkinServer;

/**
 * @description
 * @auther dogbro
 * @create 2018-11-08 17:35
 */
@EnableZipkinServer
@EnableEurekaClient
@SpringBootApplication
public class ZipkinServerApplication {

    public  static  void main(String[] args){
        new SpringApplicationBuilder(ZipkinServerApplication.class).web(true).run(args);
    }
}
