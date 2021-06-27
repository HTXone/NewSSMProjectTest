package com.TestSys.controller;

import com.TestSys.Service.CollegeService;
import com.TestSys.Service.TeacherService;
import com.TestSys.entity.College;
import com.TestSys.entity.Teacher;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @Autowired
    CollegeService collegeService;

    @RequestMapping(value = "/TeacherList.do")
    public String FindAllTeachers(@RequestParam(defaultValue = "1",required = true,value = "pageNo") Integer pageNo, Model model){
        Integer pageSize = 3;
        PageHelper.startPage(pageNo, pageSize);
        List<Teacher> teachers = teacherService.GetAllTeacher();
        PageInfo<Teacher> pageInfo = new PageInfo<>(teachers);

        model.addAttribute("teachers",teachers);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("PageUrl","/TeacherList.do");
        return "simpleTeacherList.jsp";
    }

    @RequestMapping("/toEditTeacher.do")
        public String GetEditTeachers(@RequestParam(required = true) int userID, Model model){
        Teacher teacher = teacherService.GetTeacherByID(userID);
        model.addAttribute("teacher",teacher);
        List<College> colleges= collegeService.GetAllCollege();
        model.addAttribute("collegeList",colleges);
        return "/simpleTeacherEdit.jsp";
    }

    @RequestMapping("/toAddTeacher.do")
    public String GetAddTeachers(Model model){
        List<College> colleges= collegeService.GetAllCollege();
        model.addAttribute("collegeList",colleges);
        return "/simpleTeacherAdd.jsp";
    }

    @RequestMapping(value = "/EditTeacher.do")
    public String EditTeachers(Teacher teacher, Model model){
        teacherService.UpdateTeacherInfo(teacher);
        System.out.println(teacher.toString());
        List<Teacher> teachers = teacherService.GetAllTeacher();
        model.addAttribute("teachers",teachers);
        model.addAttribute("PageUrl","/TeacherList.do");
        return "simpleTeacherList.jsp";
    }

    @RequestMapping("/AddTeacher.do")
    public String AddTeachers(Teacher teacher,Model model){
        int id = teacherService.NewTeacher(teacher);
        model.addAttribute("NewID",id);
        model.addAttribute("PWD","123456789");
        List<College> colleges= collegeService.GetAllCollege();
        model.addAttribute("collegeList",colleges);
        model.addAttribute("PageUrl","/TeacherList.do");
        return "simpleTeacherList.jsp";
    }

    @RequestMapping("/SelectTeacher.do")
    public String SelectTeachers(@RequestParam(defaultValue = "1",required = true,value = "pageNo") Integer pageNo,@RequestParam(value = "teacherName") String teacherName,Model model){
        List<Teacher> teachers = teacherService.GetTeacherByName(teacherName);

        Integer pageSize = 3;
        PageHelper.startPage(pageNo, pageSize);
//        List<Teacher> teachers = teacherService.GetAllTeacher();
        PageInfo<Teacher> pageInfo = new PageInfo<>(teachers);

        model.addAttribute("teachers",teachers);
        model.addAttribute("pageInfo",pageInfo);
        List<College> colleges= collegeService.GetAllCollege();
        model.addAttribute("collegeList",colleges);
        model.addAttribute("PageUrl","/SelectTeacher.do");
        return "simpleTeacherList.jsp";

    }






}
