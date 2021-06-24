package com.TestSys.Service.impl;

import com.TestSys.Service.StudentService;
import com.TestSys.entity.Student;
import com.TestSys.entity.User;
import com.TestSys.mapper.StudentMapper;
import com.TestSys.mapper.UserInfoMapper;
import com.TestSys.until.StringToDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentMapper studentMapper;

    @Autowired
    UserInfoMapper userMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)      //事务回滚
    public int NewStudent(String studentName, String PWD, String sex, int collegeID, String grade, String birthYear) {
        User user = new User();
        user.setUserName(studentName);
        user.setPWD(PWD);
        user.setRole(2);

        Student student = new Student();
        student.setUserName(studentName);
        student.setSex(sex);
        student.setCollegeID(collegeID);
        student.setBirthYear((birthYear.equals("")?null: StringToDate.StringToDate(birthYear)));
        student.setGrade((grade.equals("")?null: StringToDate.StringToDate(grade)));

        int ans = 0;
        try{
            int UserID = this.NewStudentID();
            user.setId(UserID);
            if(userMapper.UserExit(UserID)>0){
                return 0;
            }
            ans = userMapper.insert(user);
            if(ans>0){
                student.setUserID(UserID);
                ans = studentMapper.addStudent(student);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return ans;
    }

    @Override
    public int NewStudentID() {
        return studentMapper.selectNewID()+1;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int UpdateStudentInfo(int studentID,String studentName, String sex, int collegeID, String grade, String birthYear){
        Student student = new Student();
        student.setUserID(studentID);
        student.setUserName(studentName);
        student.setSex(sex);
        student.setCollegeID(collegeID);
        student.setGrade(StringToDate.StringToDate(grade));
        student.setBirthYear(StringToDate.StringToDate(birthYear));

        return studentMapper.UpdateStudent(student);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int DeleteStudent(int studentID) {
        studentMapper.deleteStudent(studentID);
        return userMapper.DeleteUser(studentID);
    }

}
