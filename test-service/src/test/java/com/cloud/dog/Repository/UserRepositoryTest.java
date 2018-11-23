package com.cloud.dog.Repository;

import com.cloud.dog.bean.UserEntity;
import org.apache.catalina.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @description
 * @auther dogbro
 * @date 2018-11-23 11:35
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void save(){
        UserEntity userEntity = new UserEntity();
        userEntity.setName("Alex");
        userEntity.setAge(12);
        userEntity = userRepository.save(userEntity);
        Assert.assertEquals(12, userEntity.getAge().intValue());
    }

    @Test
    public void findUser(){
        List<UserEntity> userEntities = userRepository.findUser("Alex");
//        List<UserEntity> userEntities = userRepository.findByName("Alex");
        if(userEntities != null && userEntities.size() > 0){
            Assert.assertEquals(12, userEntities.get(0).getName());
        }

    }

}