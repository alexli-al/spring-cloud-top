package com.cloud.dog.Repository;

import com.cloud.dog.bean.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @description
 * @auther dogbro
 * @date 2018-11-23 11:32
 */
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    List<UserEntity> findByName(String name);

    @Query(value = "select * from user_entity where name = ?1", nativeQuery = true )
    List<UserEntity> findUser(String name);
}
