package com.TestSys.Service.impl;

import com.TestSys.Service.UserService;
import com.TestSys.entity.User;
import com.TestSys.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserInfoMapper mapper;

    @Override
    public boolean AddUser(String UserName,String PWD) {
        User user = new User();
        user.setUserName(UserName);
        user.setPWD(PWD);
        int ans = 0;
        try{
            if(mapper.UserExit(UserName)>0){
                return false;
            }
            ans = mapper.insert(user);
        } catch (Exception e){
            e.printStackTrace();
        }

        return ans>0;
    }

    @Override
    public User Login(String UserName, String UserPWD) {
        User user = mapper.Login(UserName,UserPWD);
        return user;
    }

    @Override
    public List<User> getAllUser() {
        return mapper.SelectAll();
    }
}
