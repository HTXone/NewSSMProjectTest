package com.TestSys.Service;

import com.TestSys.entity.User;

import java.util.List;

public interface UserService {
    boolean AddUser(String UserName,String PWD,String role);
    User Login(int UserID,String UserPWD);
    List<User> getAllUser();
    boolean register(String UserName,String PWD);
    int deleteUser(int userID);
    int UpdatePWD(int userID,String OldPWD,String NewPWD);
    User SelectUser(int UserID);
}
