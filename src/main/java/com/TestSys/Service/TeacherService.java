package com.TestSys.Service;

import com.TestSys.entity.Teacher;
import com.TestSys.entity.Teacher;

import java.util.List;

public interface TeacherService {
    int NewTeacherID();
    int NewTeacher(String teacherName,String PWD,String sex,int collegeID,String grade,String birthYear,String degree,String title);
    int NewTeacher(Teacher teacher);
    int UpdateTeacher(int teacherId,String teacherName,String PWD,String sex,int collegeID,String grade,String birthYear,String degree,String title);
    int UpdateTeacherInfo(Teacher teacher);
    int DeleteTeacher(int teacherId);
    List<Teacher> GetAllTeacher();
    Teacher GetTeacherByID(int userID);
    List<Teacher> GetTeacherByName(String userName);
}
