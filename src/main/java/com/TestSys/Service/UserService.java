package com.TestSys.Service;

import com.TestSys.entity.User;

import java.util.List;

public interface UserService {
    boolean AddUser(String UserName,String PWD);
    User Login(String UserName,String UserPWD);
    List<User> getAllUser();
}
