package com.TestSys.mapper;
import org.apache.ibatis.annotations.*;
//import org.springframework.stereotype.Repository;

import com.TestSys.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserInfoMapper  {
    @Select("select * from userlogin where userName = #{userName} and password = #{password}")
    @Results(id = "UserMap",value = {
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "password",property = "PWD"),
            @Result(column = "userName",property = "userName"),
            @Result(column = "role",property = "role")
    })
    User Login(@Param("userName")String userName, @Param("password")String PWD);


    @Insert("insert into userlogin (password,userName) values (#{PWD},#{userName})")
    int insert(User user);

    @Select("select count(*) from userlogin where userName = #{userName} ")
    int UserExit(@Param("userName")String userName);

    @Select("select * from userlogin")
    @ResultMap("UserMap")
    List<User> SelectAll();

}
