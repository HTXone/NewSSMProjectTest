package com.TestSys.mapper;

import com.TestSys.entity.Classes;
import org.apache.ibatis.annotations.*;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassesMapper {

    @Select("select * from course")
    @Results(id = "ClassesMap",value = {
            @Result(id = true,column = "courseID",property = "courseID"),
            @Result(column = "courseName",property = "courseName"),
            @Result(column = "teacherID",property = "userName"),
            @Result(column = "courseTime",property = "courseTime"),
            @Result(column = "classRoom",property = "classRoom"),
            @Result(column = "courseWeek",property = "courseWeek"),
            @Result(column = "courseType",property = "courseType"),
            @Result(column = "collegeID",property = "collegeID"),
            @Result(column = "score",property = "score")
    })
    List<Classes> SelectAllClasses();

    @Insert("insert into course (courseID,courseName,teacherID,courseTime,classRoom,courseWeek,courseType,collegeID,score) values (#{courseID},#{courseName},#{teacherID},#{courseTime},#{classRoom},#{courseWeek},#{courseType},#{collegeID},#{score})")
    int AddClass(Classes classes);

    @Select("select count(*) from course")
    int SelectClassesNum();

    @Update("update course set courseName = #{courseName}, courseTime = #{courseTime}, classRoom = #{classRoom}, courseWeek = #{courseWeek}, courseType = #{courseType} where courseID = #{courseID}")
    int UpdateClass(Classes classes);

    @Delete("delete from course where courseID = #{courseID}")
    int DeleteClass(int courseID);

    @Select("SELECT MAX(courseID) FROM course")
    int SelectNewID();

    @Select("select * from course where teacherID = #{teacherID}")
    @ResultMap("ClassesMap")
    List<Classes> SelectByTeacherID(int teacherID);

}
