package com.TestSys.Service.impl;

import com.TestSys.Service.TeacherService;
import com.TestSys.entity.Student;
import com.TestSys.entity.Teacher;
import com.TestSys.entity.User;
import com.TestSys.mapper.TeacherMapper;
import com.TestSys.mapper.UserInfoMapper;
import com.TestSys.until.StringToDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    UserInfoMapper userMapper;

    @Autowired
    TeacherMapper teacherMapper;

    @Override
    public int NewTeacherID() {
        return teacherMapper.selectNewID()+1;
    }

    @Override
    public int NewTeacher(String teacherName, String PWD, String sex, int collegeID, String grade, String birthYear, String degree, String title) {
        User user = new User();
        user.setUserName(teacherName);
        user.setPWD(PWD);
        user.setRole(2);

        Teacher teacher = new Teacher();
        teacher.setUserName(teacherName);
        teacher.setSex(sex);
        teacher.setCollegeID(collegeID);
        teacher.setBirthYear((birthYear.equals("")?null: StringToDate.StringToDate(birthYear)));
        teacher.setGrade((grade.equals("")?null: StringToDate.StringToDate(grade)));
        teacher.setTitle(title);
        teacher.setDegree(degree);

        int ans = 0;
        try{
            int UserID = this.NewTeacherID();
            user.setId(UserID);
            if(userMapper.UserExit(UserID)>0){
                return 0;
            }
            ans = userMapper.insert(user);
            if(ans>0){
                teacher.setUserID(UserID);
                ans = teacherMapper.AddTeacher(teacher);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return ans;
    }

    @Override
    public int NewTeacher(Teacher teacher) {

        User user = new User();
        user.setUserName(teacher.getUserName());
        user.setPWD("123456789");
        user.setRole(1);

        int ans = 0;
        try {
            int UserID = this.NewTeacherID();
            user.setId(UserID);
            if (userMapper.UserExit(UserID) > 0) {
                return 0;
            }
            ans = userMapper.insert(user);
            if (ans > 0) {
                teacher.setUserID(UserID);
                ans = teacherMapper.AddTeacher(teacher);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return ans;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int UpdateTeacher(int teacherId, String teacherName, String PWD, String sex, int collegeID, String grade, String birthYear, String degree, String title) {
        Teacher teacher = new Teacher();
        teacher.setUserName(teacherName);
        teacher.setSex(sex);
        teacher.setCollegeID(collegeID);
        teacher.setBirthYear((birthYear.equals("")?null: StringToDate.StringToDate(birthYear)));
        teacher.setGrade((grade.equals("")?null: StringToDate.StringToDate(grade)));
        teacher.setTitle(title);
        teacher.setDegree(degree);
        teacher.setUserID(teacherId);

        return teacherMapper.UpdateTeacherInfo(teacher);
    }

    @Override
    public int UpdateTeacherInfo(Teacher teacher) {
        return teacherMapper.UpdateTeacherInfo(teacher);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int DeleteTeacher(int teacherId) {
        teacherMapper.deleteTeacher(teacherId);
        return userMapper.DeleteUser(teacherId);
    }

    @Override
    public List<Teacher> GetAllTeacher() {
        return teacherMapper.selectAllTeachers();
    }

    @Override
    public Teacher GetTeacherByID(int userID) {
        return teacherMapper.selectTeacherByID(userID);
    }

    @Override
    public List<Teacher> GetTeacherByName(String userName) {
        return teacherMapper.selectTeacherByName(userName);
    }


}
