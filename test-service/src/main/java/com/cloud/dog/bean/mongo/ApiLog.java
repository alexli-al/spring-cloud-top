package com.cloud.dog.bean.mongo;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.lang.annotation.Documented;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;

/**
 * @description 请求接口日志
 * @auther dogbro
 * @date 2018-11-22 10:45
 */
@Document(collection = "ApiLog")
public class ApiLog implements Serializable {

    @Id
    private  String id;

    //请求路劲
    private String requestUrl;

    //源IP
    private String requestOriginIp;

    //请求参数
    private  String requestParam;

    //请求开始时间
    private Date startTime;

    //请求结束时间
    private  Date endTime;

    //请求时长
    private Long requestTimes;

    public ApiLog(){}

    public ApiLog(String id, String requestUrl, String requestOriginIp, String requestParam, Date startTime, Date endTime, Long requestTimes) {
        this.id = id;
        this.requestUrl = requestUrl;
        this.requestOriginIp = requestOriginIp;
        this.requestParam = requestParam;
        this.startTime = startTime;
        this.endTime = endTime;
        this.requestTimes = requestTimes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public String getRequestOriginIp() {
        return requestOriginIp;
    }

    public void setRequestOriginIp(String requestOriginIp) {
        this.requestOriginIp = requestOriginIp;
    }

    public String getRequestParam() {
        return requestParam;
    }

    public void setRequestParam(String requestParam) {
        this.requestParam = requestParam;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Long getRequestTimes() {
        return requestTimes;
    }

    public void setRequestTimes(Long requestTimes) {
        this.requestTimes = requestTimes;
    }
}
