package com.cloud.dog.dao;

import com.cloud.dog.bean.mongo.ApiLog;
import com.sun.xml.internal.ws.api.ha.StickyFeature;

import java.util.List;

/**
 * @description
 * @auther dogbro
 * @date 2018-11-22 11:07
 */
public interface ApiLogDao {

    void  save(ApiLog apiLog);

    public ApiLog findById(String id);

    public List<ApiLog> findAll();

    public void deleteById(String id);
}
