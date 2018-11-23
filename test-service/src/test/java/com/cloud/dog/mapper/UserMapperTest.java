package com.cloud.dog.mapper;

import com.cloud.dog.bean.UserEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @description
 * @auther dogbro
 * @date 2018-11-23 10:31
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper ;

    @Test
    public void findByName(){
        userMapper.insert("dogbro", 27);
        UserEntity user = userMapper.findByName("dogbro");
        Assert.assertEquals(27, user.getAge().intValue());
    }
}