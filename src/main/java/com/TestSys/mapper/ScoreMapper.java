package com.TestSys.mapper;

import com.TestSys.entity.Score;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoreMapper {

    @Select("select * from selectedcourse where studentID = #{studentID}")
    @Results(id = "ScoreMap",value = {
            @Result(column = "courseID",property = "courseID"),
            @Result(column = "studentID",property = "studentID"),
            @Result(column = "mark",property = "mark")
    })
    List<Score> selectByStudentID(@Param("studentID") int studentID);

    @Insert("insert into selectedcourse (courseID,studentID,mark) values (#{courseID},#{studentID},#{mark})")
    int AddScore(Score score);

    @Delete("delete from selectedcourse where courseID = #{courseID} and studentID = #{studentID}")
    int delete(Score score);

    @Update("update selectedcourse set mark = #{mark} where courseID = #{courseID} and studentID = #{studentID}")
    int mark(Score score);

    @Select("select * from selectedcourse where courseID = #{courseID}")
    @ResultMap("ScoreMapper")
    List<Score> selectByCourseID(@Param("CourseID") int CourseID);

    @Select("select * from selectedcourse ")
    @ResultMap("ScoreMapper")
    List<Score> selectALL();


}