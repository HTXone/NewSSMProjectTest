package com.TestSys.mapper;


import com.TestSys.entity.Role;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMapper {

    int deleteByPrimaryKey(Integer roleid);

    int insert(Role record);

    int insertSelective(Role record);

    @Select("select * from role where roleID = #{roleid}")
    @Results(id = "RoleMap",value = {
            @Result(id = true,column = "roleID",property = "roleid"),
            @Result(column = "roleName",property = "rolename")
    })
    Role selectByPrimaryKey(Integer roleid);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}