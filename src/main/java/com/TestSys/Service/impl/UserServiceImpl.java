package com.TestSys.Service.impl;

import com.TestSys.Service.UserService;
import com.TestSys.entity.User;
import com.TestSys.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserInfoMapper mapper;

    @Autowired
    private StudentServiceImpl studentService;

    @Override
    public boolean AddUser(String UserName,String PWD,String role) {
        return false;
    }

    @Override
    public User Login(int UserID, String UserPWD) {
        User user = mapper.Login(UserID,UserPWD);
        return user;
    }

    @Override
    public List<User> getAllUser() {
        return mapper.SelectAll();
    }

    @Override
    public boolean register(String UserName, String PWD) {
        return studentService.NewStudent(UserName,PWD,"m",0,"","")>0;
    }

    @Override
    public int deleteUser(int userID) {
        return mapper.DeleteUser(userID);
    }

    @Override
    public int UpdatePWD(int userID, String OldPWD, String NewPWD) {
        User user = mapper.Login(userID,OldPWD);
        if (user == null){return 0;}
        return mapper.UpdateUserPWD(userID,NewPWD);
    }

    @Override
    public User SelectUser(int UserID) {
        return mapper.SelectUser(UserID);
    }
}
