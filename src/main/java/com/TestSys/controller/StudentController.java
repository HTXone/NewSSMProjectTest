package com.TestSys.controller;

import com.TestSys.Service.CollegeService;
import com.TestSys.Service.StudentService;
import com.TestSys.entity.College;
import com.TestSys.entity.Student;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class StudentController {
    @Autowired
    StudentService studentService;

    @Autowired
    CollegeService collegeService;

    @RequestMapping("/StudentList.do")
    public String FindAllStudents(@RequestParam(defaultValue = "1",required = true,value = "pageNo") Integer pageNo,Model model){
        Integer pageSize = 3;
        PageHelper.startPage(pageNo, pageSize);
        List<Student> students = studentService.GetAllStudent();
        PageInfo<Student> pageInfo = new PageInfo<>(students);

        model.addAttribute("students",students);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("PageUrl","/StudentList.do");
        return "simpleStudentList.jsp";
    }

    @RequestMapping("/toEditStudent.do")
    public String GetEditStudents(@RequestParam(required = true) int userID, Model model){
        Student student = studentService.GetStudentByID(userID);
        model.addAttribute("student",student);
        List<College> colleges= collegeService.GetAllCollege();
        model.addAttribute("collegeList",colleges);
        return "/simpleStudentEdit.jsp";
    }

    @RequestMapping("/toAddStudent.do")
    public String GetAddStudents( Model model){
        List<College> colleges= collegeService.GetAllCollege();
        model.addAttribute("collegeList",colleges);
        return "/simpleStudentAdd.jsp";
    }

    @RequestMapping("/EditStudent.do")
    public String EditStudents(@RequestParam(defaultValue = "1",required = true,value = "pageNo") Integer pageNo,Student student, Model model){
        Integer pageSize = 3;
        PageHelper.startPage(pageNo, pageSize);
        studentService.UpdateStudentInfo(student);
        List<Student> students = studentService.GetAllStudent();
        model.addAttribute("students",students);
        PageInfo<Student> pageInfo = new PageInfo<>(students);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("PageUrl","/StudentList.do");
        return "simpleStudentList.jsp";
    }

    @RequestMapping("/AddStudent.do")
    public String AddStudents(Student student,Model model){
        int id = studentService.NewStudent(student);
        model.addAttribute("NewID",id);
        model.addAttribute("PWD","123456789");
        List<College> colleges= collegeService.GetAllCollege();
        model.addAttribute("URL","/StudentList.do");
        return "success.jsp";
    }

    @RequestMapping("/SelectStudent.do")
    public String SelectStudents(@RequestParam(defaultValue = "1",required = true,value = "pageNo") Integer pageNo,@RequestParam(value = "studentName") String studentName,Model model){
        List<Student> students = studentService.GetStudentByName(studentName);

        Integer pageSize = 3;
        PageHelper.startPage(pageNo, pageSize);
//        List<Student> students = studentService.GetAllStudent();
        PageInfo<Student> pageInfo = new PageInfo<>(students);

        model.addAttribute("students",students);
        model.addAttribute("pageInfo",pageInfo);
        List<College> colleges= collegeService.GetAllCollege();
        model.addAttribute("collegeList",colleges);
        model.addAttribute("PageUrl","/SelectStudent.do");
        return "simpleStudentList.jsp";

    }

    @RequestMapping("/StudentSuccess.do")
    public String SuccessBack(@RequestParam(defaultValue = "1",required = true,value = "pageNo") Integer pageNo,Model model){
        return this.FindAllStudents(pageNo,model);
    }




}
