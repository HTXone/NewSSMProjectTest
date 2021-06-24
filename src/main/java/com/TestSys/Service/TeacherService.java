package com.TestSys.Service;

public interface TeacherService {
    int NewTeacherID();
    int NewTeacher(String teacherName,String PWD,String sex,int collegeID,String grade,String birthYear,String degree,String title);
    int UpdateTeacher(int teacherId,String teacherName,String PWD,String sex,int collegeID,String grade,String birthYear,String degree,String title);
    int DeleteTeacher(int teacherId);
}
