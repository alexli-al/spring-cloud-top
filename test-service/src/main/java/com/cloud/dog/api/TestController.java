package com.cloud.dog.api;

import com.cloud.dog.client.TestServiceBClient;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/test1")
public class TestController {

    private final Logger  logger = Logger.getLogger(getClass());

    @Autowired
    private TestServiceBClient testServiceBClient;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String test(){
        logger.info(getClass());
        return "hello world!";
    }

    @RequestMapping(value = "/callLink")
    public String test2(HttpServletRequest request){
        return testServiceBClient.test2();
    }
}
