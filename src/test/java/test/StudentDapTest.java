package test;

import com.TestSys.entity.Classes;
import com.TestSys.entity.Student;
import com.TestSys.mapper.ClassesMapper;
import com.TestSys.mapper.StudentMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:spring/applicationContext-dao.xml",
        "classpath:spring/applicationContext-service.xml"
})
public class StudentDapTest {

    @Autowired
    StudentMapper studentMapper;

    @Autowired
    ClassesMapper classesMapper;



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


    @Test
    public void ClassEditTest(){
        Classes classes = new Classes();
        classes.setCourseID(1);
        classes.setCourseName("1231");
        classes.setTeacherID(1001);
        classes.setCourseTime("2");
        classes.setClassRoom("1222");
        classes.setCourseWeek(19);
        classes.setCourseType("AAA");
        classes.setCollegeID(4);
        classes.setScore(2);
        System.out.println(classesMapper.UpdateClass(classes));
    }
}
