package com.TestSys.entity;

import org.springframework.stereotype.Repository;


public class Score {
    private int courseID;
    private int studentID;
    private int mark;

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
