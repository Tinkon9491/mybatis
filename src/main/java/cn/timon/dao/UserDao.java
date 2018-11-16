package cn.timon.dao;

import cn.timon.pojo.User;

public interface UserDao {
    //id查找用户
    User findUserById(Integer id);
    //插入新用户
    void insertUser(User user);
}
