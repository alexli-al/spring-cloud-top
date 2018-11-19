package com.cloud.dog.config;

import com.dogbro.bean.RestAPI;
import com.dogbro.exception.CustomException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @description
 * 创建全局异常处理类：通过使用@ControllerAdvice定义统一的异常处理类，而不是在每个Controller中逐个定义。
 * @ExceptionHandler用来定义函数针对的异常类型，最后将Exception对象和请求URL映射到error.html中
 * @auther dogbro
 * @date 2018-11-19 16:39
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 系统异常处理, @ResponseBody适用于返回josn
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public RestAPI errorHandler(Exception e){
            return RestAPI.systemError(e);
    }

    /**
     * 自定义异常处理
     * @param ce
     * @return
     */
    @ExceptionHandler(value = CustomException.class)
    @ResponseBody
    public RestAPI customerErrorHandler(CustomException ce){
            RestAPI restAPI = new RestAPI();
            restAPI.setCode(500);
            restAPI.setMsg(ce.getMessage());
            restAPI.setData(null);
            return  restAPI;

    }

}
