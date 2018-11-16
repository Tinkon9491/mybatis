package cn.timon.mapper;

import cn.timon.pojo.CustomOrders;
import cn.timon.pojo.Orders;
import cn.timon.pojo.QueryVo;
import cn.timon.pojo.User;

import java.util.List;
/**
 * 接口
 * */
public interface UserMapper {
    //	1.根据用户id查询用户
    public User queryUserById(Integer id);

    //	2.新增一个用户
    public void insertUser(User user);

    //3.修改用户

    public User updateUser(Integer id);

    //4.删除一个用户
    public void deleteUserById(Integer id);

    public List<User> findUserByVo(QueryVo queryVo);

    public Integer findUserCount();

    public List<User> findUserByIds(QueryVo queryVo);

    public List<CustomOrders>  findOrdersAndUser1();

    public List<Orders>  findOrdersAndUser2();

    public List<User> findUserAndOrders();

}
