package com.TestSys.mapper;

import com.TestSys.entity.College;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;



import java.util.List;

@Repository
public interface CollegeMapper {
    @Select("select * from college")
    @Results(id = "CollegeMap",value = {
            @Result(id = true,column = "collegeID",property = "collegeID"),
            @Result(column = "collegeName",property = "collegeName")
    })
    List<College> selectAllCollege();

    @Insert("insert into college (collegeID,collegeName) values (#{collegeID},#{collegeName})")
    int AddCollege(College college);

    @Delete("delete from college where collegeID = #{collegeID}")
    int deleteCollege(int collegeID);

    @Update("update college set collegeName = #{collegeName} where collegeID = #{collegeID}")
    int UpdateCollege(College college);

    @Select("SELECT MAX(collegeID) FROM college")
    int selectNewID();
}
