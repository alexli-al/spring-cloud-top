package com.cloud.dog.client;

import com.cloud.dog.fallback.TestServiceHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @description
 * @auther dogbro
 * @create 2018-11-08 16:37
 */
@FeignClient(value = "test-service-b", fallback = TestServiceHystrix.class)
public interface TestServiceBClient {

    @RequestMapping(value = "/test2/test", method = RequestMethod.GET)
    public String test2();
}
