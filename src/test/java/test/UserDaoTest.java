package test;

import com.TestSys.entity.User;
import com.TestSys.mapper.ScoreMapper;
import com.TestSys.mapper.TeacherMapper;
import com.TestSys.mapper.UserInfoMapper;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:spring/applicationContext-dao.xml"
})
public class UserDaoTest {
    @Autowired
    private SqlSessionFactory sessionFactory;
    private SqlSession session;
    private UserInfoMapper UDao;
    @Autowired
    private ScoreMapper scoreMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private BasicDataSource dataSource;

    @Test
    public void testConnection(){
        try {
            Connection connection = dataSource.getConnection();
            System.out.println(connection);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Test
    public void init() throws IOException {
        session = sessionFactory.openSession();
        UDao = session.getMapper(UserInfoMapper.class);
        System.out.println(UDao);
    }

    @Test
    public void addNewUser() throws IOException {
        session = sessionFactory.openSession();
        UDao = session.getMapper(UserInfoMapper.class);
        User user = new User();
        user.setUserName("799");
        user.setPWD("799");
        System.out.println(UDao.insert(user));
    }

    @Test
    public void UserExit() throws IOException{
        System.out.println(userInfoMapper.UserExit(799));
    }

    @Test
    public void ScoreSelect() throws IOException{
        System.out.println(scoreMapper.selectByCourseID(1).get(0).getStudentName());
    }

    @Test
    public void TeacherSelect() {
        System.out.println(teacherMapper.selectTeacherByName("老师"));
    }



}
