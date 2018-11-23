package com.cloud.dog.dao;

import com.cloud.dog.bean.mongo.ApiLog;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @description
 * @auther dogbro
 * @date 2018-11-22 11:19
 */
//@SpringApplicationConfiguration 老版本
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiLogDaoTest {

    @Autowired
    private ApiLogDao apiLogDao;

    @Test
    public void save() {
        ApiLog apiLog = new ApiLog();
        apiLog.setRequestParam("test");
        apiLogDao.save(apiLog);
    }

    @Test
    public void findById() {
    }

    @Test
    public void findAll() {
    }

    @Test
    public void deleteById() {
    }
}