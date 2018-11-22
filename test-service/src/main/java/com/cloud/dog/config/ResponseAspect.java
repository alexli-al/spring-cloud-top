package com.cloud.dog.config;

import com.cloud.dog.bean.mongo.ApiLog;
import com.dogbro.bean.RestAPI;
import com.netflix.discovery.converters.Auto;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @description
 * @auther dogbro
 * @date 2018-11-20 17:37
 */
@Aspect
@Component
public class ResponseAspect {

//    @Autowired
//    private  HttpServletRequest request;

    private final Logger LOGGER = LoggerFactory.getLogger(ResponseAspect.class);

    @Autowired
    private MappingJackson2HttpMessageConverter converter;

    @Autowired
    private MongoTemplate mt;

    @Pointcut("execution(public * com.cloud.dog.api..*.*(..)) ")
    private void responseBodyPointCut(){}

    @Around(value = "responseBodyPointCut()")
    private void  around(ProceedingJoinPoint jp) throws Throwable{
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        ApiLog apiLog = new ApiLog();
        wrapRequestInfo(request, apiLog);
        apiLog.setStartTime(new Date());

        Object object =  jp.proceed();
        apiLog.setEndTime(new Date());
        apiLog.setRequestTimes(apiLog.getEndTime().getTime() - apiLog.getEndTime().getTime());

        RestAPI restAPI = null;

        //统一接口返回数据格式
        if(object instanceof  RestAPI){
            //发生异常GlobalExceptionHandler 会封装异常数据返回RestAPI
            restAPI = (RestAPI)object;
        }else{
            //接口正常返回
            restAPI =RestAPI.buildSuccess(object);
        }
       // mt.save(apiLog); //保存请求日志到数据库
        /**
         * 直接return restAPI，如果api中返回基础数据类型，比如String就会报错com.dogbro.bean.RestAPI cannot be cast to java.lang.String
         * 接口中返回类型不固定，可能是封装对象也有可能是基础对象，这里最后统一返回RestAPI类型会出现转换错误
         * 所以直接将数据流write回去
         */
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        HttpOutputMessage outputMessage = new ServletServerHttpResponse(response);
        converter.write(restAPI, MediaType.APPLICATION_JSON_UTF8,outputMessage);
//        return restAPI;
    }

    private void wrapRequestInfo(HttpServletRequest request, ApiLog apiLog) {
        if(apiLog == null){
            apiLog = new ApiLog();
        }
        apiLog.setRequestOriginIp(request.getRemoteAddr());
        apiLog.setRequestUrl(request.getRequestURI());
        //***8
    }
}
