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
        model.addAttribute("param1","");
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

    @RequestMapping(value = "/EditTeacher.do",method = RequestMethod.POST)
    public String EditTeachers(Teacher teacher, Model model){
        teacherService.UpdateTeacherInfo(teacher);
        return this.FindAllTeachers(1,model);
    }

    @RequestMapping(value = "/AddTeacher.do",method = RequestMethod.POST)
    public String AddTeachers(Teacher teacher,Model model){
        int id = teacherService.NewTeacher(teacher);
        return this.FindAllTeachers(1,model);
    }

    @RequestMapping("/SelectTeacher.do")
    public String SelectTeachers(@RequestParam(defaultValue = "1",required = true,value = "pageNo") Integer pageNo,@RequestParam(value = "param") String teacherName,Model model){

        Integer pageSize = 3;
        PageHelper.clearPage();
        PageHelper.startPage(pageNo, pageSize);
        List<Teacher> teachers = teacherService.GetTeacherByName(teacherName);
//        List<Teacher> teachers = teacherService.GetAllTeacher();
            PageInfo<Teacher> pageInfo = new PageInfo<>(teachers);

        model.addAttribute("teachers",teachers);
        model.addAttribute("pageInfo",pageInfo);
        List<College> colleges= collegeService.GetAllCollege();
        model.addAttribute("collegeList",colleges);
        model.addAttribute("PageUrl","/SelectTeacher.do");
        model.addAttribute("param1",teacherName);

        return "simpleTeacherList.jsp";

    }






}
