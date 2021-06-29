package com.TestSys.controller;

import com.TestSys.Service.UserService;
import com.TestSys.entity.User;
import com.TestSys.mapper.UserInfoMapper;
import org.apache.ibatis.annotations.Param;
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
    public String login(String userID, String userPWD, HttpSession session,Model model) throws Exception {

        //Shiro实现登录
        UsernamePasswordToken token = new UsernamePasswordToken(userID, userPWD);
        Subject subject = SecurityUtils.getSubject();
        try {
            //如果获取不到用户名就是登录失败，但登录失败的话，会直接抛出异常
            subject.login(token);

            User user = userService.SelectUser(Integer.parseInt(userID));
            session.setAttribute("user", user);
            if (subject.hasRole("admin")) {
                return "/StudentList.do";
            } else if (subject.hasRole("teacher")) {
                return "/TeacherClassesList.do?param="+user.getId();
            } else if (subject.hasRole("student")) {
                return "/StudentIndex.do?studentID="+user.getId();
            }
        }catch (Exception e){
            model.addAttribute("loginfail",1);
            return "/login.jsp";
        }
        model.addAttribute("loginfail",1);
        return "/login.jsp";
    }

    @RequestMapping(value = "/PWDCharge.do", method = {RequestMethod.POST})
    public String PWDChange(@RequestParam("UserID")int UserID, @RequestParam("oldPassword") String OldPWD, @RequestParam("password2") String NewPWD){
        int ans = userService.UpdatePWD(UserID,OldPWD,NewPWD);
        if(ans>0){
            return "/login.jsp";
        }
        return "/index.jsp";
    }


    @RequestMapping("/UserList.do")
    public String getAllUser(Model model){
        List<User> userList = userService.getAllUser();
        model.addAttribute("ss", userList);
        return "list.jsp";
    }

    @RequestMapping("/logout.do")
    public String Logout(HttpSession session,Model model){
        session.setAttribute("user",null);
        return "/login.jsp";
    }



}
