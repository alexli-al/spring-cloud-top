package com.cloud.dogbro.fallback;

import com.cloud.dogbro.client.TestServiceClient;
import org.springframework.stereotype.Controller;

/**
 * Hystrix回调方法实现类
 */
@Controller
public class TestServiceHystrix implements TestServiceClient {
    @Override
    public String hello() {
        return "The fallback page!";
    }
}
