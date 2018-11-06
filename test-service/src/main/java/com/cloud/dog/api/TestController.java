package com.cloud.dog.api;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final Logger  logger = Logger.getLogger(getClass());

        @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String test(){
        logger.info(getClass());
        return "hello world!";
    }
}
