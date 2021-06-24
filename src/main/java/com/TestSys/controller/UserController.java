package com.TestSys.controller;

import com.TestSys.Service.UserService;
import com.TestSys.entity.User;
import com.TestSys.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/login.do",method = {RequestMethod.POST})
    public ModelAndView login(@RequestParam(required = true) String userID, @RequestParam(required = true) String userPWD,  HttpServletResponse response){
        ModelAndView mv = new ModelAndView();

        User emps = userService.Login(userID,userPWD);
        if(emps == null){
            mv.setViewName("/login.html");
            mv.addObject("loginfail", true);
            return mv;
        }

        List<User> userList = new ArrayList<>();

        userList.add(emps);
        mv.setViewName("/emp.jsp");
        mv.addObject("ss", userList);
        return mv;
    }

    @RequestMapping(value = "/register.do" , method = RequestMethod.POST)
    public String register(@RequestParam(required = true) String userEmail, @RequestParam(required = true) String userPWD,  Model model){
        boolean a = userService.register(userEmail,userPWD);
        if(a) {
            List<User> userList = new ArrayList<>();
            User emps = userService.Login(userEmail, userPWD);
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
