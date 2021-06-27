package com.TestSys.Service.impl;

import com.TestSys.Service.CollegeService;
import com.TestSys.entity.College;
import com.TestSys.mapper.CollegeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CollegeServiceImpl implements CollegeService {

    @Autowired
    CollegeMapper collegeMapper;

    @Override
    public int NewCollege(String CollegeName) {
        College college = new College();
        college.setCollegeName(CollegeName);
        int ans = 0;
        try{
            int NewID = collegeMapper.selectNewID();
            college.setCollegeID(NewID);
            ans = collegeMapper.AddCollege(college);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ans;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int UpdateCollege(int CollegeID,String CollegeName){
        College college = new College();
        college.setCollegeID(CollegeID);
        college.setCollegeName(CollegeName);
        return collegeMapper.UpdateCollege(college);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int DeleteCollege(int CollegeID) {
        return collegeMapper.deleteCollege(CollegeID);
    }

    @Override
    public List<College> GetAllCollege() {
        return collegeMapper.selectAllCollege();
    }


    @Override
    public int NewCollegeID() {
        return collegeMapper.selectNewID();
    }
}
