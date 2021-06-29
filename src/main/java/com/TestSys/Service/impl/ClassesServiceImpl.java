package com.TestSys.Service.impl;

import com.TestSys.Service.ClassesService;
import com.TestSys.entity.Classes;
import com.TestSys.entity.Score;
import com.TestSys.mapper.ClassesMapper;
import com.TestSys.mapper.ScoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClassesServiceImpl implements ClassesService {

    @Autowired
    ClassesMapper classesMapper;

    @Autowired
    ScoreMapper scoreMapper;

    @Override
    public int NewClass(String ClassName, String ClassTime, int TeacherID, String ClassRoom, String ClassType, int ClassWeek, int CollegeID) {
        Classes classes = new Classes();
        classes.setCourseName(ClassName);
        classes.setScore(0);
        classes.setCourseTime(ClassTime);
        classes.setClassRoom(ClassRoom);
        classes.setTeacherID(TeacherID);
        classes.setCourseType(ClassType);
        classes.setCollegeID(CollegeID);
        classes.setCourseWeek(ClassWeek);

        int ans = 0;

        try{
            int ClassID = classesMapper.SelectNewID();
            classes.setCourseID(ClassID);
            ans = classesMapper.AddClass(classes);
        }catch (Exception e){
            e.printStackTrace();
        }

        return ans;
    }

    @Override
    public int NewClass(Classes classes) {
        int ans = 0;

        try{
            int ClassID = classesMapper.SelectNewID()+1;
            classes.setCourseID(ClassID);
            ans = classesMapper.AddClass(classes);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ans;
    }

    @Override
    public int NewClassID() {
        return classesMapper.SelectNewID()+1;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int UpdateClass(int ClassID, String ClassName, String ClassTime, String ClassRoom, String ClassType, int ClassWeek,int Score) {

        if(this.UsedClass(ClassID)) return 0;

        Classes classes = new Classes();

        classes.setCourseID(ClassID);
        classes.setCourseName(ClassName);
        classes.setScore(0);
        classes.setCourseTime(ClassTime);
        classes.setClassRoom(ClassRoom);

        classes.setCourseType(ClassType);
        classes.setCourseWeek(ClassWeek);

        return classesMapper.UpdateClass(classes);

    }

    @Override
    public int UpdateClassInfo(Classes classes) {
        System.out.println(classes.toString());
        if(this.UsedClass(classes.getCollegeID())) return 0;
        return classesMapper.UpdateClass(classes);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int DeleteClass(int ClassID) {
        if(this.UsedClass(ClassID)) return 0;
        return classesMapper.DeleteClass(ClassID);
    }

    @Override
    public boolean UsedClass(int ClassID) {
        List<Score> scoreList = scoreMapper.selectByCourseID(ClassID);
        if(scoreList.size()>0){
            System.out.println("USED");
            return false;
        }
        return true;
    }

    @Override
    public List<Classes> SelectAllClasses() {
        return classesMapper.SelectAllClasses();
    }

    @Override
    public Classes SelectClassesByID(int classesID) {
        return classesMapper.SelectClassesByID(classesID);
    }

    @Override
    public List<Classes> SelectClassesByTeacher(int TeacherID) {
        return classesMapper.SelectByTeacherID(TeacherID);
    }

    @Override
    public List<Classes> SelectClassesByName(String className) {
        return classesMapper.SelectByClassName("%"+className+"%");
    }

    @Override
    public List<Classes> StudentSelectedClasses(int studentID) {
        return classesMapper.SelectByStudentSelected(studentID);
    }

    @Override
    public List<Classes> StudentScore(int studentID) {
        return classesMapper.StudentScore(studentID);
    }

    @Override
    public int[] StudentScoreCount(int studentID) {
        int[] a = new int[4];
        int score = 0;
        int sum = 0;
        List<Classes> classes = classesMapper.StudentScore(studentID);
        for (Classes i:classes) {
            if(i.getCourseType().equals("必修课") ){
                a[0]+=i.getScore();
            }else if (i.getCourseType().equals("选修课")){
                a[1]+=i.getScore();
            }else{
                a[2]+=i.getScore();
            }
            score+=i.getScore()*i.getMark();
            sum+=i.getScore();
        }
        a[3]=score/sum;
        return a;
    }


}
