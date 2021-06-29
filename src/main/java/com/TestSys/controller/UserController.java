package com.TestSys.controller;

import com.TestSys.Service.UserService;
import com.TestSys.entity.User;
import com.TestSys.mapper.UserInfoMapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/login.do", method = {RequestMethod.POST})
    public String login(String userID, String userPWD, HttpSession session) throws Exception {

        //Shiro实现登录
        UsernamePasswordToken token = new UsernamePasswordToken(userID, userPWD);
        Subject subject = SecurityUtils.getSubject();

        //如果获取不到用户名就是登录失败，但登录失败的话，会直接抛出异常
        subject.login(token);

        User user = userService.SelectUser(Integer.parseInt(userID));
        session.setAttribute("user",user);
        if (subject.hasRole("admin")) {
            return "/index.jsp";
        } else if (subject.hasRole("teacher")) {
            return "/index.jsp";
        } else if (subject.hasRole("student")) {
            return "/index.jsp";
        }

        return "/login.jsp";
    }

    @RequestMapping(value = "/register.do" , method = RequestMethod.POST)
    public String register(@RequestParam(required = true) String userID, @RequestParam(required = true) String userPWD,  Model model){
        boolean a = userService.register(userID,userPWD);
        if(a) {
            List<User> userList = new ArrayList<>();
            User emps = userService.Login(1, userPWD);
            userList.add(emps);
            model.addAttribute("ss", userList);
            return "emp.jsp";
        }
        return null;
    }

    @RequestMapping("/UserList.do")
    public String getAllUser(Model model){
        List<User> userList = userService.getAllUser();
        model.addAttribute("ss", userList);
        return "list.jsp";
    }



}
