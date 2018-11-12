package com.cloud.dogbro.api;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/test2")
public class TestController {

    private final Logger logger = Logger.getLogger(getClass());

        @RequestMapping(value = "/test")
        public String test(HttpServletRequest request) throws Exception{
            logger.info("===<call trace-2, TraceId=" + request.getHeader("X-B3-TraceId") + ", SpanId={}>==="
                    +request.getHeader("X-B3-SpanId"));
            return "test2 method of test-service-b! ";
        }
}
