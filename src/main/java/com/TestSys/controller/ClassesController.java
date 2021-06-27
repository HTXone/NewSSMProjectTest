package com.TestSys.controller;

import com.TestSys.Service.CollegeService;
import com.TestSys.Service.ClassesService;
import com.TestSys.entity.College;
import com.TestSys.entity.Classes;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ClassesController {
    @Autowired
    ClassesService classesService;

    @Autowired
    CollegeService collegeService;

    @RequestMapping("/ClassesList.do")
    public String FindAllClassess(@RequestParam(defaultValue = "1",required = true,value = "pageNo") Integer pageNo, Model model){
        Integer pageSize = 3;
        PageHelper.startPage(pageNo, pageSize);
        List<Classes> classess = classesService.SelectAllClasses();
        PageInfo<Classes> pageInfo = new PageInfo<>(classess);

        model.addAttribute("classess",classess);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("PageUrl","/ClassesList.do");
        return "simpleClassesList.jsp";
    }

    @RequestMapping("/TeacherClassesList.do")
    public String FindTeacherClassess(@RequestParam(defaultValue = "1",required = true,value = "pageNo") Integer pageNo,@RequestParam(value = "teacherID") int TeacherID, Model model){
        Integer pageSize = 3;
        PageHelper.startPage(pageNo, pageSize);
        List<Classes> classess = classesService.SelectClassesByTeacher(TeacherID);
        PageInfo<Classes> pageInfo = new PageInfo<>(classess);

        model.addAttribute("classess",classess);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("PageUrl","/ClassesList.do");
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
        model.addAttribute("PageUrl","/ClassesList.do");
        return "simpleClassesList.jsp";
    }

    @RequestMapping("/toEditClasses.do")
    public String GetEditClassess(@RequestParam(required = true) int ID, Model model){
        Classes classes = classesService.SelectClassesByID(ID);
        model.addAttribute("classes",classes);
        List<College> colleges= collegeService.GetAllCollege();
        model.addAttribute("collegeList",colleges);
        return "/simpleClassesEdit.jsp";
    }

    @RequestMapping("/EditClasses.do")
    public String EditClassess(Classes classes, Model model){
        classesService.UpdateClassInfo(classes);
        List<Classes> classess = classesService.SelectAllClasses();
        model.addAttribute("classess",classess);
        model.addAttribute("PageUrl","/ClassesList.do");
        return "simpleClassesList.jsp";
    }

    @RequestMapping("/AddClasses.do")
    public String AddClassess(Classes classes,Model model){
        int id = classesService.NewClass(classes);
        model.addAttribute("NewID",id);
        model.addAttribute("PWD","123456789");
        List<College> colleges= collegeService.GetAllCollege();
        model.addAttribute("collegeList",colleges);
        model.addAttribute("PageUrl","/ClassesList.do");
        return "simpleClassesList.jsp";
    }

    @RequestMapping("/SelectClasses.do")
    public String SelectClassess(@RequestParam(defaultValue = "1",required = true,value = "pageNo") Integer pageNo,@RequestParam(value = "classesName") String classesName,Model model){
        List<Classes> classess = classesService.SelectClassesByName(classesName);

        Integer pageSize = 3;
        PageHelper.startPage(pageNo, pageSize);
//        List<Classes> classess = classesService.GetAllClasses();
        PageInfo<Classes> pageInfo = new PageInfo<>(classess);

        model.addAttribute("classess",classess);
        model.addAttribute("pageInfo",pageInfo);
        List<College> colleges= collegeService.GetAllCollege();
        model.addAttribute("collegeList",colleges);
        model.addAttribute("PageUrl","/SelectClasses.do");
        return "simpleClassesList.jsp";

    }



}
