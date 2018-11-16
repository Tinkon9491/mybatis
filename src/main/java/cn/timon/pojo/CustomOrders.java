package cn.timon.pojo;

import java.util.Date;
/**
 * 新建一个类来存放用户和订单表，继承订单，拿用户表的字节
 * */
public class CustomOrders extends Orders {
    private Integer uid; // int(11) NOT NULL AUTO_INCREMENT,
    private String username; // varchar(32) NOT NULL COMMENT '用户名称',
    private Date birthday; // date DEFAULT NULL COMMENT '生日',
    private String sex; // char(1) DEFAULT NULL COMMENT '性别',
    private String address; // varchar(256) DEFAULT NULL COMMENT '地址',

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
