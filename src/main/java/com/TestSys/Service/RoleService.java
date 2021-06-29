package com.TestSys.Service;


import com.TestSys.entity.Role;

/**
 *  Role 权限表Service层
 */
public interface RoleService {

    Role findByid(Integer id) throws Exception;

}
