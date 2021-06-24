package com.TestSys.mapper;

import com.TestSys.entity.Teacher;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherMapper {

    @Select("select * from teacher")
    @Results(id = "TeacherMap",value = {
            @Result(id = true,column = "userID",property = "userID"),
            @Result(column = "userName",property = "userName"),
            @Result(column = "sex",property = "sex"),
            @Result(column = "birthYear",property = "birthYear"),
            @Result(column = "degree",property = "degree"),
            @Result(column = "title",property = "title"),
            @Result(column = "grade",property = "grade"),
            @Result(column = "collegeID",property = "collegeID")
    })
    List<Teacher> selectAllTeachers();

    @Insert("insert into teacher (userID,userName,sex,birthYear,degree,title,grade,collegeID) values (#{userID},#{userName},#{sex},#{birthYear},#{degree},#{title},#{grade},#{collegeID})")
    int AddTeacher(Teacher teacher);

    @Delete("delete from teacher where userID = #{userID}")
    int deleteTeacher(int userID);

    @Update("Update teacher set userName = #{userName},sex = #{sex},birthYear = #{birthYear},degree = #{degree},title = #{title},grade = #{grade},collegeID = #{collegeID} where userID = #{userID}")
    int UpdateTeacherInfo(Teacher teacher);

    @Select("SELECT MAX(userID) FROM teacher")
    int selectNewID();

}
