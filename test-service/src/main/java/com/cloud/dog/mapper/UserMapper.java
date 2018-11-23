package com.cloud.dog.mapper;

import com.cloud.dog.bean.UserEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @description
 * @auther dogbro
 * @date 2018-11-23 10:03
 */
@Mapper
public interface UserMapper {

    @Select("select * from user")
    List<UserEntity> getAll();

    @Select("select * from userEntity where name = #{name}")
    UserEntity findByName(@Param("name") String name);

    /**
     * 这里获取表中自增的ID返回到userEntity的id字段，自增需要在数据库中指定，userEntity中不需要指定任何orm注解
     */
    @Insert("insert into userEntity (name, age) values(#{name},#{age})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    Integer insert(@Param("name") String name, @Param("age") Integer age);

}
