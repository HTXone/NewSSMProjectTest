package test;

import com.TestSys.Service.ScoreService;
import com.TestSys.Service.StudentService;
import com.TestSys.Service.impl.StudentServiceImpl;
import com.TestSys.entity.Student;
import com.TestSys.mapper.StudentMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:spring/applicationContext-dao.xml",
        "classpath:spring/applicationContext-controller.xml"
})
public class StudentDapTest {

    @Autowired
    StudentMapper studentMapper;



    @Test
    public void GetStudent(){
//        List<Student> students = studentMapper.selectAllStudents();
//        System.out.println(students.get(0).getBirthYear());
        System.out.println(studentMapper.selectStudentByID(10001).getSex());
    }

    @Test
    public void NewStudentTest(){
        Student student = new Student();

    }
}
