package com.TestSys.entity;

public class College {
    private int collegeID;
    private String collegeName;

    public int getCollegeID() {
        return collegeID;
    }

    public void setCollegeID(int collegeID) {
        this.collegeID = collegeID;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    @Override
    public String toString() {
        return "collegeID{" +
                "collegeID=" + collegeID +
                ", collegeName='" + collegeName + '\'' +
                '}';
    }
}
