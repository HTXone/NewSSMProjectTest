package com.TestSys.mapper;
import org.apache.ibatis.annotations.*;
//import org.springframework.stereotype.Repository;

import com.TestSys.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserInfoMapper  {
    @Select("select * from userlogin where userID = #{userName} and password = #{password}")
    @Results(id = "UserMap",value = {
            @Result(id = true,column = "userID",property = "id"),
            @Result(column = "password",property = "PWD"),
            @Result(column = "userName",property = "userName"),
            @Result(column = "role",property = "role")
    })
    User Login(@Param("userName")int userName, @Param("password")String PWD);


    @Insert("insert into userlogin (userID,password,userName,role) values (#{id},#{PWD},#{userName},#{role})")
    int insert(User user);

    @Select("select count(*) from userlogin where userID = #{userName} ")
    int UserExit(@Param("userName")int userName);

    @Select("select * from userlogin")
    @ResultMap("UserMap")
    List<User> SelectAll();

    //修改密码
    @Update("update userlogin set password = #{password} where userID = #{userName}")
    int UpdateUserPWD(@Param("userName")int userName,@Param("password") String PWD);

    @Delete("delete from userlogin where userID = #{userID}")
    int DeleteUser(int userID);

    @Select("select * from userlogin where userID = #{userID}")
    @ResultMap("UserMap")
    User SelectUser(int userID);

}
