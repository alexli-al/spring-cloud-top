package com.cloud.dog.api;

import com.cloud.dog.client.TestServiceBClient;
import com.dogbro.exception.CustomException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/test1")
@Api(description = "测试接口")
public class TestController {

    private final Logger  logger = Logger.getLogger(getClass());

    @Autowired
    private TestServiceBClient testServiceBClient;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String test(){
        logger.info(getClass());
        return "hello world!";
    }

    @RequestMapping(value = "/callLink", method = RequestMethod.GET)
    public String test2(HttpServletRequest request){
        return testServiceBClient.test2();
    }

    @RequestMapping(value = "/json",method = RequestMethod.GET)
    @ApiOperation(value = "全局处理自定义系统异常", nickname = "全局处理自定义系统异常")
    public String json() throws CustomException{
        throw new CustomException("我出异常啦");
    }

    @RequestMapping(value =  "/json2", method = RequestMethod.GET)
    @ApiOperation(value = "全局处理系统异常", nickname = "全局处理系统异常")
    public String json2() throws  Exception{
        throw new RuntimeException("系统出异常了！");
    }
}
