package com.TestSys.entity;

import org.springframework.stereotype.Repository;

import java.util.Date;


public class Student extends Person{
    private int userID;
    private String userName;
    private String sex;
    private Date birthYear;
    private Date grade;
    private int collegeID;

    public Student(){
        super();
    }

    @Override
    public String toString() {
        return "Student{" +
                "userID=" + userID +
                ", userName='" + userName + '\'' +
                ", sex='" + sex + '\'' +
                ", birthYear='" + birthYear + '\'' +
                ", grade='" + grade + '\'' +
                ", collegeID=" + collegeID +
                '}';
    }
}
