package com.cloud.dog.dao.impl;

import com.cloud.dog.bean.mongo.ApiLog;
import com.cloud.dog.dao.ApiLogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description
 * @auther dogbro
 * @date 2018-11-22 11:10
 */
@Component
public class ApiLogDaoImpl implements ApiLogDao {

    @Autowired
    private MongoTemplate mt;

    @Override
    public void  save(ApiLog apiLog) {
        mt.save(apiLog);
    }

    @Override
    public ApiLog findById(String id) {
        return mt.findById(id, ApiLog.class);
    }

    @Override
    public List<ApiLog> findAll() {
        return mt.findAll(ApiLog.class);
    }

    @Override
    public void deleteById(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
         mt.remove(query, ApiLog.class);

    }
}
