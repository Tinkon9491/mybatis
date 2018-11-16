package mybais;

import cn.timon.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class UserTest {
    @Test
    public void testFindUserById() throws Exception{
        String resource = "sqlMapConfig.xml";
        //读取核心配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //通过核心配置文件输入流来创建工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        //通过工厂创建会话
        SqlSession sqlSession = factory.openSession();
        User user = sqlSession.selectOne("test.findUserById",1);
        System.out.println(user);
        sqlSession.close();
    }


    @Test
    public void  testFindUserByUserName() throws  Exception{
        String resource = "sqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession  = factory.openSession();
        List<User> list =  sqlSession.selectList("test.findUserByUserName","明");
        System.out.println(list);
        sqlSession.close();
    }
    @Test
    public void insertUser() throws Exception{
        String resource = "sqlMapConfig.xml";
        //读取核心配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //通过核心配置文件输入流来创建工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        //通过工厂创建会话
        SqlSession sqlSession = factory.openSession();

        User user = new User();
//        user.setId(3);
        user.setUsername("李红");
        user.setSex("1");
        user.setBirthday(new Date());
        user.setAddress("东莞大朗");

        sqlSession.insert("test.insertUser",user);

        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void updateUserTest() throws Exception {
        String resource = "sqlMapConfig.xml";
        //读取核心配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //通过核心配置文件输入流来创建工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        //通过工厂创建会话
        SqlSession sqlSession = factory.openSession();

        // 2.使用sqlSession对象，调用方法执行
        // update方法：更新记录
        // 参数statement：执行的sql语句（名称空间+sql语句id）
        // 参数parameter：传入的参数值
        // 创建用户对象
        User user = new User();
        user.setId(14);
        user.setUsername("李寻");
        user.setSex("1");

        sqlSession.update("test.updateUser", user);

        sqlSession.commit();

        // 3.释放资源
        sqlSession.close();
    }

    @Test
    public void deleteUserById() throws  Exception{
        String resource = "sqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = factory.openSession();
        sqlSession.delete("test.deleteUserById",15);
        sqlSession.commit();
        System.out.println("delet ok");

        sqlSession.close();

    }

}
