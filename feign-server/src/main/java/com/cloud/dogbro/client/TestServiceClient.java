package com.cloud.dogbro.client;

import com.cloud.dogbro.fallback.TestServiceHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//通过test-service找到TEST-SERVER，然后mapping到hello路径
@FeignClient(value = "test-service",fallback = TestServiceHystrix.class)
public interface TestServiceClient {
    //接口定义,这里的路径匹配test-service里面的路径
    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String hello();
}
