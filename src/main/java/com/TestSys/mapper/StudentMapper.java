package com.TestSys.mapper;

import com.TestSys.entity.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentMapper {

    @Select("select * from student")
    @Results(id = "StudentMap",value = {
            @Result(id = true,column = "userID",property = "userID"),
            @Result(column = "userName",property = "userName"),
            @Result(column = "sex",property = "sex"),
            @Result(column = "birthYear",property = "birthYear"),
            @Result(column = "grade",property = "grade"),
            @Result(column = "collegeID",property = "collegeID")
    })
    List<Student>selectAllStudents();

    @Insert("insert into student (userID,userName,sex,birthYear,grade,collegeID) values (#{userID},#{userName},#{sex},#{birthYear},#{grade},#{collegeID})")
    int addStudent(Student student);

    @Update("update student set userName = #{userName},sex = #{sex},birthYear = #{birthYear},grade = #{grade},collegeID = #{collegeID} where userID = #{userID}")
    int UpdateStudent(Student student);

    @Delete("delete from student where userID = #{userID}")
    int deleteStudent(int userID);

    @Select("SELECT MAX(userID) FROM student")
    int selectNewID();



}
