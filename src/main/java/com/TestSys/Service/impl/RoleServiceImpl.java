package com.TestSys.Service.impl;

import com.TestSys.Service.RoleService;
import com.TestSys.entity.Role;
import com.TestSys.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleMapper roleMapper;

    @Override
    public Role findByid(Integer id) throws Exception {
        return roleMapper.selectByPrimaryKey(id);
    }
}
