package com.TestSys.Service;

import com.TestSys.entity.College;

import java.util.List;

public interface CollegeService {
    int NewCollege(String CollegeName);
    int NewCollegeID();
    int UpdateCollege(int CollegeID,String CollegeName);
    int DeleteCollege(int CollegeID);
    List<College> GetAllCollege();
}
