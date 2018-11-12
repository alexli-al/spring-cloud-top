package com.cloud.dog.fallback;

import com.cloud.dog.client.TestServiceBClient;
import org.springframework.stereotype.Component;

/**
 * @description
 * @auther dogbro
 * @create 2018-11-08 16:42
 */
@Component
public class TestServiceHystrix implements TestServiceBClient {
    @Override
    public String test2() {
        return "This is the fallback method of the TestServiceHystrix";
    }
}
