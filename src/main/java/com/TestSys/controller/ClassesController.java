package com.TestSys.controller;

import com.TestSys.Service.CollegeService;
import com.TestSys.Service.ClassesService;
import com.TestSys.Service.ScoreService;
import com.TestSys.Service.TeacherService;
import com.TestSys.entity.College;
import com.TestSys.entity.Classes;
import com.TestSys.entity.Score;
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
public class ClassesController {
    @Autowired
    ClassesService classesService;

    @Autowired
    CollegeService collegeService;

    @Autowired
    ScoreService scoreService;

    @Autowired
    TeacherService teacherService;

    @RequestMapping("/ClassesList.do")
    public String FindAllClassess(@RequestParam(defaultValue = "1",required = true,value = "pageNo") Integer pageNo, Model model){
        Integer pageSize = 3;
        PageHelper.clearPage();
        PageHelper.startPage(pageNo, pageSize);
        List<Classes> classess = classesService.SelectAllClasses();
        PageInfo<Classes> pageInfo = new PageInfo<>(classess);

        model.addAttribute("classess",classess);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("PageUrl","/ClassesList.do");
        model.addAttribute("param1","");
        return "simpleClassesList.jsp";
    }

    @RequestMapping("/TeacherClassesList.do")
    public String FindTeacherClassess(@RequestParam(defaultValue = "1",required = true,value = "pageNo") Integer pageNo,@RequestParam(value = "param") int TeacherID, Model model){
        Integer pageSize = 3;
        PageHelper.startPage(pageNo, pageSize);
        List<Classes> classess = classesService.SelectClassesByTeacher(TeacherID);
        PageInfo<Classes> pageInfo = new PageInfo<>(classess);

        model.addAttribute("classess",classess);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("PageUrl","/TeacherClassesList.do");
        model.addAttribute("param1",TeacherID+"");
        return "simpleClassesList.jsp";
    }



    @RequestMapping("/StudentsClassesList.do")
    public String FindStudentsClassess(@RequestParam(defaultValue = "1",required = true,value = "pageNo") Integer pageNo, Model model){
        Integer pageSize = 3;
        PageHelper.startPage(pageNo, pageSize);
        List<Classes> classess = classesService.SelectAllClasses();
        PageInfo<Classes> pageInfo = new PageInfo<>(classess);


        model.addAttribute("classess",classess);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("PageUrl","/StudentsClassesList.do");
        model.addAttribute("param1","");
        model.addAttribute("Selected",0);
        return "simpleClassesList.jsp";
    }

    @RequestMapping("/toEditClasses.do")
    public String GetEditClassess(@RequestParam(required = true) int ID, Model model){
        Classes classes = classesService.SelectClassesByID(ID);
        model.addAttribute("classes",classes);
        List<College> colleges= collegeService.GetAllCollege();
        model.addAttribute("collegeList",colleges);
        List<Teacher> teacherList = teacherService.GetAllTeacher();
        model.addAttribute("teacherList",teacherList);
        return "/simpleClassesEdit.jsp";
    }

    @RequestMapping("/toAddClasses.do")
    public String GetAddClassess( Model model){
        List<College> colleges= collegeService.GetAllCollege();
        model.addAttribute("collegeList",colleges);
        List<Teacher> teacherList = teacherService.GetAllTeacher();
        model.addAttribute("teacherList",teacherList);
        return "/simpleClassesAdd.jsp";
    }

    @RequestMapping(value = "/EditClasses.do",method = RequestMethod.POST)
    public String EditClassess(Classes classes, Model model){
        classes.setTeacherID(classes.getTeacherID());
        int ans =classesService.UpdateClassInfo(classes);

        System.out.println(ans);
        return this.FindAllClassess(1,model);
    }

    @RequestMapping(value = "/AddClasses.do",method = RequestMethod.POST)
    public String AddClassess(Classes classes,Model model){
        int id = classesService.NewClass(classes);
        System.out.println(classes);
        System.out.println(id);
        return this.FindAllClassess(1,model);
    }

    @RequestMapping("/SelectClasses.do")
    public String SelectClassess(@RequestParam(defaultValue = "1",required = true,value = "pageNo") Integer pageNo,@RequestParam(value = "param") String classesName,Model model){


        Integer pageSize = 3;
        PageHelper.startPage(pageNo, pageSize);
//        List<Classes> classess = classesService.GetAllClasses();
        List<Classes> classess = classesService.SelectClassesByName(classesName);
        PageInfo<Classes> pageInfo = new PageInfo<>(classess);

        model.addAttribute("classess",classess);
        model.addAttribute("pageInfo",pageInfo);
        List<College> colleges= collegeService.GetAllCollege();
        model.addAttribute("collegeList",colleges);
        model.addAttribute("PageUrl","/SelectClasses.do");
        model.addAttribute("param1",classesName);
        return "simpleClassesList.jsp";

    }


    @RequestMapping("/StudentSelectedClass.do")
    public String SelectStudentSelectedClasses(@RequestParam(defaultValue = "1",required = true,value = "pageNo") Integer pageNo,@RequestParam(value = "param") int studentID,Model model){
        List<Classes> classes = classesService.StudentSelectedClasses(studentID);
        Integer pageSize = 3;
        PageHelper.startPage(pageNo, pageSize);
        PageInfo<Classes> pageInfo = new PageInfo<>(classes);
        model.addAttribute("classess",classes);
        model.addAttribute("pageInfo",pageInfo);
        List<College> colleges= collegeService.GetAllCollege();
        model.addAttribute("collegeList",colleges);
        model.addAttribute("PageUrl","/StudentSelectedClass.do");
        model.addAttribute("param1",studentID);
        model.addAttribute("Selected",2);

        return "simpleClassesList.jsp";
    }

    @RequestMapping(value = "/SelectedCourse.do")
    public String SelectedCourse(@RequestParam(defaultValue = "1",required = true,value = "pageNo") Integer pageNo,@RequestParam("courseID") int courseID,@RequestParam("studentID") int StudentID, Model model) {
        int ans = scoreService.SelectedCourse(courseID,StudentID);
        model.addAttribute("ans", ans);
        return this.SelectStudentSelectedClasses(pageNo,StudentID,model);
    }

    @RequestMapping(value = "/RemoveSelectedCourse.do")
    public String RemoveSelectedCourse(@RequestParam(defaultValue = "1",required = true,value = "pageNo") Integer pageNo,@RequestParam("studentID") int StudentID,@RequestParam("courseID") int courseID, Model model){
        int ans = scoreService.RemoveSelectedCourse(courseID,StudentID);
        return this.SelectStudentSelectedClasses(pageNo,StudentID,model);
    }

    @RequestMapping("/StudentScore.do")
    public String StudentScore(@RequestParam(defaultValue = "1",required = true,value = "pageNo") Integer pageNo,@RequestParam(value = "param") int studentID,Model model){
        Integer pageSize = 3;
        PageHelper.startPage(pageNo, pageSize);
        List<Classes> classes = classesService.StudentScore(studentID);
        PageInfo<Classes> pageInfo = new PageInfo<>(classes);
        model.addAttribute("classess",classes);
        model.addAttribute("pageInfo",pageInfo);
        List<College> colleges= collegeService.GetAllCollege();
        model.addAttribute("collegeList",colleges);
        model.addAttribute("PageUrl","/StudentScore.do");
        model.addAttribute("param1",studentID);
        model.addAttribute("Selected",1);

        return "simpleClassesList.jsp";
    }

    @RequestMapping("/StudentIndex.do")
    public String StudentScoreCount(@RequestParam("studentID")int studentID,Model model){
        int arr[] = classesService.StudentScoreCount(studentID);
        model.addAttribute("StudentCount",arr);
        return "simpleStudentIndex.jsp";
    }



}
