package com.TestSys.controller;

import com.TestSys.Service.ClassesService;
import com.TestSys.Service.CollegeService;
import com.TestSys.Service.ScoreService;
import com.TestSys.Service.StudentService;
import com.TestSys.entity.Classes;
import com.TestSys.entity.Score;
import com.TestSys.entity.Student;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ScoreController {

    @Autowired
    ScoreService scoreService;

    @Autowired
    StudentService studentService;

    @RequestMapping("/ScoreList.do")
    public String FindAllScores(@RequestParam(defaultValue = "1",required = true,value = "pageNo") Integer pageNo, Model model){
        Integer pageSize = 3;
        PageHelper.startPage(pageNo, pageSize);
        List<Score> scores = scoreService.SelectAllScore();
        PageInfo<Score> pageInfo = new PageInfo<>(scores);

        model.addAttribute("scores",scores);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("PageUrl","/ClassesList.do");
        return "simpleGradeList.jsp";
    }

    @RequestMapping("/CourseScoreList.do")
    public String FindCourseScores(@RequestParam(defaultValue = "1",required = true,value = "pageNo") Integer pageNo,@RequestParam(value = "courseID")int courseID, Model model){
        Integer pageSize = 3;
        PageHelper.startPage(pageNo, pageSize);
        List<Score> scores = scoreService.SelectScoreByCourseID(courseID);
        PageInfo<Score> pageInfo = new PageInfo<>(scores);

        model.addAttribute("selectedCourseList",scores);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("PageUrl","/CourseScoreList.do");
        return "simpleGradeList.jsp";
    }

    @PatchMapping("/toMark.do")
    public String toMark(@RequestParam("courseID") int courseID,@RequestParam("studentID") int studentID,@RequestParam("studentName") int studentName, Model model){
        model.addAttribute("courseID",courseID);
        model.addAttribute("studentID",studentID);
        model.addAttribute("studentName",studentName);

        return "simpleMark.jsp";
    }

    @PatchMapping("/Mark.do")
    public String Mark(@RequestParam("courseID") Score score,@RequestParam(defaultValue = "1",required = true,value = "pageNo") Integer pageNo,@RequestParam(value = "courseID")int courseID, Model model){
        scoreService.MarkScore(score);

        return this.FindCourseScores(pageNo,courseID,model);
    }



}
