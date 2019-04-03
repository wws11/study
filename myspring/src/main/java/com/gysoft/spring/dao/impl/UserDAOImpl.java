package com.gysoft.spring.dao.impl;

import com.gysoft.spring.bean.User;
import com.gysoft.spring.bean.UserInfo;
import com.gysoft.spring.dao.IUserDAO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/4/2 11:27
 */


public class UserDAOImpl extends JdbcDaoSupport implements IUserDAO {


    @Override
    public void addUser(User user) {
        String sql = "insert into user values(?,?,?)";
        this.getJdbcTemplate().update(sql, user.getId(), user.getUserName(),
                user.getPassword());
        System.out.println("添加成功");
    }

    @Override
    public void deleteUser(String id) {
        String sql = "delete from user where id=?";
        this.getJdbcTemplate().update(sql, id);
        System.out.println("删除成功");

    }

    @Override
    public void updateUser(User user) {
        String sql = "update user set username=?,password=? where id=?";
        this.getJdbcTemplate().update(sql, user.getUserName(),
                user.getPassword(), user.getId());
    }

    @Override
    public String searchUserName(String id) {// 简单查询，按照ID查询，返回字符串
        String sql = "select username from user where id=?";
        // 返回类型为String(String.class)
        return this.getJdbcTemplate().queryForObject(sql, String.class, id);

    }

    @Override
    public List<User> findAll() {// 复杂查询返回List集合
        String sql = "select * from user";
        return this.getJdbcTemplate().query(sql, new UserRowMapper());

    }

    @Override
    public User searchUser(String id) {
        String sql = "select * from user where id=?";
        return this.getJdbcTemplate().queryForObject(sql, new UserRowMapper(), id);
    }

    class UserRowMapper implements RowMapper<User> {
        //rs为返回结果集，以每行为单位封装着
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {

            User user = new User();
            user.setId(rs.getString("id"));
            user.setUserName(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            return user;
        }
    }


    //连接查询测试


    @Override
    public List getUserInfoList() {
        StringBuffer sql = new StringBuffer();
        sql.append("select u.userName ,u.password,un.unitName,un.unitUserCount from user as u inner join unit as un on un.userId =u.id");
        //
        List<Map<String, String>> list = this.getJdbcTemplate().query(sql.toString(), (resultSet, i) -> {
            Map<String, String> mp = new HashMap<String, String>();
            mp.put("userName", resultSet.getString("userName"));
            mp.put("password", resultSet.getString("password"));
            mp.put("unitName", resultSet.getString("unitName"));
            mp.put("unitUserCount", resultSet.getString("unitUserCount"));
            return mp;
        });
        return list;
    }

    //测试jdbcTemplate 的连接查询使用的返回数据使用对象存储

    @Override
    public List<UserInfo> getUserInfoListByInfo() {
        StringBuffer sql = new StringBuffer();
        sql.append("select u.userName ,u.password,un.unitName,un.unitUserCount from user as u inner join unit as un on un.userId =u.id");
        //
        List<UserInfo> list = this.getJdbcTemplate().query(sql.toString(), new RowMapper<UserInfo>() {
            @Override
            public UserInfo mapRow(ResultSet resultSet, int i) throws SQLException {

                UserInfo userInfo = new UserInfo();
                userInfo.setUserNmae(resultSet.getString("userName"));
                userInfo.setPassword(resultSet.getString("password"));
                userInfo.setUnitName(resultSet.getString("unitName"));
                userInfo.setUnitUserCount(resultSet.getInt("unitCount"));
                return userInfo;
            }
        });
        return list;
    }

    @Override
    public void batchAddUser(List<User> users) {

        final List<User> tempUser = users;

        String sql = "insert into user(id,userName,password) values (?,?,?)";

        this.getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                //注意这里的下标从1开始
                String id = tempUser.get(i).getId();
                String userName = tempUser.get(i).getUserName();
                String password = tempUser.get(i).getPassword();
                ps.setString(1, id);
                ps.setString(2, userName);
                ps.setString(3, password);
            }

            @Override
            public int getBatchSize() {

                return tempUser.size();
            }
        });
    }

    @Override
    public void batchDelete(List<String> ids) {


        if (ids.size() > 0) {
            StringBuilder sql = new StringBuilder();
            List<String> marks = (List) ids.stream().map((s) -> {
                return "?";
            }).collect(Collectors.toList());
            sql.append(" DELETE FROM user " + " WHERE  id" + " in (");
            sql.append(String.join(",", marks));
            sql.append(")");


            /*this.getJdbcTemplate().update(sql.toString(), ids.toArray());

        List<Object[]> deleteParams = new ArrayList<Object[]>();
        String sql="delete from user where id in (?)";

        ids.forEach(e->{
            deleteParams.add(new Object[]{e});
        });
        this.getJdbcTemplate().batchUpdate(sql,deleteParams);
        this.getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                for (int j = 0; j <ids.size() ; j++) {
                    ps.setString(i,ids.get(i));
                }

            }

            @Override
            public int getBatchSize() {
                return ids.size();
            }
        });*/

        }

    }

    @Override
    public List<User> queryWithCriter(String userName, String Password) {
        String sql="select * from user where userName= (?)"+" or password = (?)";
        List<User> list = this.getJdbcTemplate().query(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {

                User user = new User();
                user.setId(resultSet.getString("id"));
                user.setUserName(resultSet.getString("userName"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }
        });
        return list;
    }
}
