package com.TestSys.entity;

import org.springframework.stereotype.Repository;


public class Score {
    private int courseID;
    private int studentID;
    private Integer mark;
    private String userName;
    private boolean over = false;

    public boolean isOver() {
        if(this.mark != null ){
            this.over = true;
//            System.out.println("IN");
        }
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

    public Integer getMark() {
        if(this.mark != null ){
            this.over = true;
//            System.out.println("IN");
        }
//        System.out.println("OUT");
        return mark;
    }

    public void setMark(int mark) {
        if(this.mark != null ){
            this.over = true;
        }
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
