package cn.timon.dao.impl;

import cn.timon.dao.UserDao;
import cn.timon.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;


import java.util.Date;

public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {
    /**
     * mybatis不使用spring管理的方法
     * */
    /**
    private SqlSessionFactory sqlSessionFactory;

    public UserDaoImpl() {
        super();
    }

    public UserDaoImpl(SqlSessionFactory sqlSessionFactory){
        super();
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public User findUserById(Integer id) {
        SqlSession sqlSession = this.sqlSessionFactory.openSession();
        User user =sqlSession.selectOne("test.findUserById",id);
        sqlSession.close();
        return (User) user;
    }

    public void insertUser(User user) {
        SqlSession sqlSession = this.sqlSessionFactory.openSession(true);

        sqlSession.insert("test.insertUser",user);
        sqlSession.close();
    }
 **/
    @Override
    public User findUserById(Integer id) {
        SqlSession sqlSession = this.getSqlSession();
        User user =sqlSession.selectOne("test.findUserById",id);

        return (User) user;
    }
    @Override
    public void insertUser(User user) {
        SqlSession sqlSession = this.getSqlSession();

        sqlSession.insert("test.insertUser",user);
    }

}
