package com.gysoft.spring.dao;

import com.gysoft.spring.bean.User;
import com.gysoft.spring.bean.UserInfo;
import sun.security.util.Password;

import java.util.List;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/4/2 11:26
 */
public interface IUserDAO {

    void addUser(User user);

    void deleteUser(String id);

    void updateUser(User user);

    String searchUserName(String id);

    User searchUser(String id);

    List<User> findAll();

    List getUserInfoList();

    List<UserInfo> getUserInfoListByInfo();

    void batchAddUser(List<User> users);

    void  batchDelete(List<String>  ids);

    List<User>  queryWithCriter(String userName, String Password);
}