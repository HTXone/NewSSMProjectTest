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
    @Transactional(propagation = Propagation.REQUIRED)
    public int DeleteClass(int ClassID) {
        if(this.UsedClass(ClassID)) return 0;
        return classesMapper.DeleteClass(ClassID);
    }

    @Override
    public boolean UsedClass(int ClassID) {
        List<Score> scoreList = scoreMapper.selectByCourseID(ClassID);
        if(scoreList.size()>0){
            return false;
        }
        return true;
    }

    @Override
    public List<Classes> SelectAllClasses() {
        return classesMapper.SelectAllClasses();
    }

    @Override
    public List<Classes> SelectClassesByTeacher(int TeacherID) {
        return classesMapper.SelectByTeacherID(TeacherID);
    }

    


}
