package com.gysoft.spring.jdbcTemplate;

import com.gysoft.spring.bean.User;
import com.gysoft.spring.dao.IUserDAO;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/4/2 11:20
 */


/*@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application.xml")*/
public class JdbcTemplateTest {
    ApplicationContext applicationContext;
    IUserDAO dao;

     {

        applicationContext =new ClassPathXmlApplicationContext("jdbcTemplate.xml");
         dao=(IUserDAO) applicationContext.getBean("userDao");
    }
    //测试添加操作
    @Test
    public void  test1(){
        User user=new User();
        user.setId(UUID.randomUUID().toString());
         user.setUserName("admin");
        user.setPassword("123456");
        dao.addUser(user);
    }


    @Test//改
    public void demo2(){
        User user=new User();
        user.setId("cdf7b516-0914-4d47-9df0-4ae13bace7c7");
        user.setUserName("jdbc 666");
        user.setPassword("123456");
        dao.updateUser(user);
    }
    @Test//删
    public void demo3(){

        dao.deleteUser("dae145be-e60f-4d86-ad6e-b67fb28e9c58");
    }

    @Test//查（简单查询，返回字符串）
    public void demo4(){
         //不存在的话会报异常 expected 1, actual 0
        String name=dao.searchUserName("cdf7b516-0914-4d47-9df0-4ae13bace7c7");
        System.out.println(name);
    }

    @Test//查（简单查询，返回对象）
    public void demo5(){
        User user=dao.searchUser("cdf7b516-0914-4d47-9df0-4ae13bace7c7");
        System.out.println(user);
    }

    @Test//查（复杂查询，返回对象集合）
    public void demo6(){
        List<User> users=dao.findAll();
        System.out.println(users.size());
    }

    /**
     * 测试连接查询
     */
    @Test
    public   void demo7(){
        List userInfoList = dao.getUserInfoList();
        Optional.ofNullable(userInfoList).orElseGet(ArrayList::new).forEach(e->{

            System.out.println(e);
        });
    }

    //测试jdbc 使用info对象作为返回值
    @Test
    public   void demo8(){
        List userInfoList = dao.getUserInfoList();
        Optional.ofNullable(userInfoList).orElseGet(ArrayList::new).forEach(e->{

            System.out.println(e);
        });
    }
    //测试批量添加
    @Test
    public  void  testBatchAdd(){
        List<User>  users=new ArrayList<>();
        User user1 = new User();
        user1.setUserName("dgdg");
        user1.setId("fsfs");
        user1.setPassword("ddd");
        User user2=new User();
        user2.setId("ddfsf");
        user2.setPassword("www");
        user2.setUserName("cc");
        users.add(user1);
        users.add(user2);
        dao.batchAddUser(users);

    }
    //测试批量删除
    @Test
    public  void  batchDelete(){
        //删除有问题
        List<String>  ids=new ArrayList<>();
        ids.add("ddfsf");
        ids.add("fafwefewf");
        dao.batchDelete(ids);
    }
    //测试条件查询
    @Test
    public  void  test11(){
        //有问题，待解决
        dao.queryWithCriter("dgdg","gyadmin");
    }



}
