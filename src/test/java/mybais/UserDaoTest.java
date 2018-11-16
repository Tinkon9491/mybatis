package mybais;

import cn.timon.dao.UserDao;
import cn.timon.dao.impl.UserDaoImpl;
import cn.timon.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

public class UserDaoTest {

     private SqlSessionFactory sqlSessionFactory = null;

    @Before
    public void init() throws IOException{
        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        sqlSessionFactory = builder.build(inputStream);
    }

    @Test
    public void queryUserByIdTest(){
        // 1.创建用户dao实现类对象
        UserDao userDao = new UserDaoImpl(sqlSessionFactory);

        // 2.使用userDao对象，调用方法执行
        User user = userDao.findUserById(2);
        System.out.println(user);
    }

    @Test
   public  void insertUserTest(){
        UserDao userDao= new UserDaoImpl(sqlSessionFactory);

        User user = new User();
        user.setUsername("小李");
        user.setSex("1");
        user.setAddress("青海西宁");
        user.setBirthday(new Date());
        userDao.insertUser(user);
    }



}
