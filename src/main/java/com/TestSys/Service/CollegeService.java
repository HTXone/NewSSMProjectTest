package com.TestSys.Service;

public interface CollegeService {
    int NewCollege(String CollegeName);
    int NewCollegeID();
    int UpdateCollege(int CollegeID,String CollegeName);
    int DeleteCollege(int CollegeID);
}
