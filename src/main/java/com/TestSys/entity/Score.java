package com.TestSys.entity;

import org.springframework.stereotype.Repository;


public class Score {
    private int courseID;
    private int studentID;
    private int mark;
    private String userName;
    private boolean over;

    public boolean isOver() {
        return over;
    }

    public void setOver(boolean over) {
        this.over = over;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getStudentName() {
        return userName;
    }

    public void setStudentName(String studentName) {
        this.userName = studentName;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Score{" +
                "courseID=" + courseID +
                ", studentID=" + studentID +
                ", mark=" + mark +
                '}';
    }
}
