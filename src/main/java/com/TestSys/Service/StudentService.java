package com.TestSys.Service;

import com.TestSys.entity.Student;

import java.util.List;

public interface StudentService {
    int NewStudent(String studentName,String PWD,String sex,int collegeID,String grade,String birthYear);
    int NewStudent(Student student);
    int NewStudentID();
    int UpdateStudentInfo(int studentID,String studentName, String sex, int collegeID, String grade, String birthYear);
    int UpdateStudentInfo(Student student);
    int DeleteStudent(int studentID);
    List<Student> GetAllStudent();
    Student GetStudentByID(int userID);
    List<Student> GetStudentByName(String userName);

}
