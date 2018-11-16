package mybais;

import cn.timon.mapper.UserMapper;
import cn.timon.pojo.CustomOrders;
import cn.timon.pojo.Orders;
import cn.timon.pojo.QueryVo;
import cn.timon.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserMapperTest {

    private SqlSessionFactory sqlSessionFactory = null;

    @Before
    public void init() throws IOException{
        String resource = "sqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        sqlSessionFactory = builder.build(inputStream);
    }
    /*
       根据用户ID查询用户信息
   * */
    @Test
   public void queryUserByIdTest() {
        SqlSession sqlSession = this.sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.queryUserById(2);
        System.out.println(user);
        sqlSession.close();
    }
    /**
     * 新增一个用户
     * */
    @Test
    public void insertUserTest(){
        SqlSession sqlSession = this.sqlSessionFactory.openSession(true);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("小张");
        user.setSex("1");
        user.setAddress("北京昌平");
        user.setBirthday(new Date());

        userMapper.insertUser(user);
        System.out.println(user);
        sqlSession.close();
    }
    /**
     * 根据用户id修改用户
     * **/
    @Test
    public void updateUserTest(){
        SqlSession sqlSession = this.sqlSessionFactory.openSession(true);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        
    }

    /**
     * 根据用户id删除一个用户
     * **/
    @Test
    public void deleteUserByIdTest() {
        SqlSession sqlSession = this.sqlSessionFactory.openSession(true);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.deleteUserById(17);
        sqlSession.close();
    }

    @Test
    public void findUserByVoTest(){
        SqlSession sqlSession = this.sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        QueryVo queryVo = new QueryVo();
        User user = new User();
        user.setUsername("小");
        user.setSex("1");
        queryVo.setUser(user);
        List<User> list = userMapper.findUserByVo(queryVo);
        System.out.println(list);
    }
    //查找表中数量
    @Test
    public void findUserCount(){
        SqlSession sqlSession = this.sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Integer integer = userMapper.findUserCount();
        System.out.println(integer);
        sqlSession.close();
    }
    //根据多id查用户
    @Test
    public void findUserByIdsTest(){
        SqlSession sqlSession = this.sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        QueryVo queryVo = new QueryVo();
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(4);
        ids.add(6);
        ids.add(10);
        queryVo.setIds(ids);
        List<User> list =userMapper.findUserByIds(queryVo);
        System.out.println(list);
    }
    //一对一：有订单查询用户
    @Test
    public void findOrdersAndUser1Test(){
        SqlSession sqlSession = this.sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<CustomOrders> ordersAndUser1 = userMapper.findOrdersAndUser1();
        System.out.println(ordersAndUser1);
        sqlSession.close();
    }
    //一对一：有订单查询用户
    @Test
    public void findOrdersAndUser2Test(){
        SqlSession sqlSession = this.sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<Orders> ordersAndUser2 = userMapper.findOrdersAndUser2();
        System.out.println(ordersAndUser2);
        sqlSession.close();
    }
    //一对多：有用户查询订单
    @Test
    public void findUserAndOrdersTest(){
        SqlSession sqlSession = this.sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        List<User> userAndOrders = userMapper.findUserAndOrders();
        System.out.println(userAndOrders);
        sqlSession.close();
    }
}
