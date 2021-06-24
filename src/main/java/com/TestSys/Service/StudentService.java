package com.TestSys.Service;

public interface StudentService {
    int NewStudent(String studentName,String PWD,String sex,int collegeID,String grade,String birthYear);
    int NewStudentID();
    int UpdateStudentInfo(int studentID,String studentName, String sex, int collegeID, String grade, String birthYear);
    int DeleteStudent(int studentID);

}
