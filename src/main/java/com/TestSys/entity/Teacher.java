package com.TestSys.entity;

import java.util.Date;

public class Teacher extends Person{
    private int userID;
    private String userName;
    private String sex;
    private Date birthYear;
    private String degree;
    private String title;
    private Date grade;
    private int collegeID;

    public Teacher(){
        super();
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    @Override
    public String toString() {
        return "Teacher{" +
                "userID=" + userID +
                ", userName='" + userName + '\'' +
                ", sex='" + sex + '\'' +
                ", birthYear='" + birthYear + '\'' +
                ", degree='" + degree + '\'' +
                ", title='" + title + '\'' +
                ", grade='" + grade + '\'' +
                ", collegeID=" + collegeID +
                '}';
    }
}
