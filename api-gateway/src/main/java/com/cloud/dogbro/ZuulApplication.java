package com.cloud.dogbro;

import com.cloud.dogbro.filter.AccessFilter;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringCloudApplication // @SpringBootApplication、@EnableDiscoveryClient、@EnableCircuitBreaker
@EnableZuulProxy //开启zuul
public class ZuulApplication {
    public static  void main(String[] args){
        new SpringApplicationBuilder(ZuulApplication.class).web(true).run(args);
    }

    //实例化过滤器
    @Bean
    public AccessFilter getFilter(){
        return new AccessFilter();
    }
}
