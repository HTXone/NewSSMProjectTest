package com.TestSys.entity;

public class Classes {

    private int courseID;
    private String courseName;
    private String teacherID;
    private String courseTime;
    private String classRoom;
    private int courseWeek;
    private String courseType;
    private int collegeID;
    private int score;

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(String teacherID) {
        this.teacherID = teacherID;
    }

    public String getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(String courseTime) {
        this.courseTime = courseTime;
    }

    public String getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }

    public int getCourseWeek() {
        return courseWeek;
    }

    public void setCourseWeek(int courseWeek) {
        this.courseWeek = courseWeek;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public int getCollegeID() {
        return collegeID;
    }

    public void setCollegeID(int collegeID) {
        this.collegeID = collegeID;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Classes{" +
                "courseID=" + courseID +
                ", courseName='" + courseName + '\'' +
                ", teacherID='" + teacherID + '\'' +
                ", courseTime='" + courseTime + '\'' +
                ", classRoom='" + classRoom + '\'' +
                ", courseWeek=" + courseWeek +
                ", courseType='" + courseType + '\'' +
                ", collegeID=" + collegeID +
                ", score=" + score +
                '}';
    }
}