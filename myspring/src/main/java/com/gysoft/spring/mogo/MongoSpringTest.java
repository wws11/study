package com.gysoft.spring.mogo;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/4/19 16:56
 */


public class MongoSpringTest {
    @Resource
    private MongoTemplate  mongoTemplate;


    @Before
    public void testBefore() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        mongoTemplate = (MongoTemplate) context.getBean("mongoTemplate");
    }

           /* * 插入用户信息*/
    @Test
    public void testAddUser() {
        Student student = new Student();
        student.setName("zhangsan");
        student.setSex("1");
        student.setAge(12);
        student.setAddress("余杭区戏子国际");

        // 插入数据
        mongoTemplate.insert(student);
    }

    @Test
    public void getAllUser() {

        List<Student> all = mongoTemplate.findAll(Student.class);
        all.forEach(e->{
            System.out.println(e);
        });
    }


    /**
     * 查询
     */
    @Test
    public void queryWithCriter(){
        Criteria criteria = new Criteria();
        criteria.and("name").is("zhangsan");

        Query query = new Query();
        query.addCriteria(criteria);
        List<Student> students = mongoTemplate.find(query, Student.class);
        System.out.println(students);

        // 排序查询sort方法,按照age降序排列
        // query.sort().on("age", Order.DESCENDING);
        // List<User> userList2 = mongoTemplate.find(query, User.class);
        // printList(userList2);

// 排序　
/*Query query = new Query();
　　　　　　query.with(new Sort(Direction.ASC, "priority").and(new Sort(Direction.ASC, "create_time")));*/




        // 指定字段查询,只查询age和name两个字段
        // query.fields().include("age").include("name");
        // List<User> userList3 = mongoTemplate.find(query, User.class);
        // printList(userList3);

        // 分页查询
        // query.skip(2).limit(3);
        // List<User> userList4 = mongoTemplate.find(query, User.class);
        // printList(userList4);

        // 查询所有
        // printList(mongoTemplate.findAll(User.class));

        // 统计数据量
        // System.out.println(mongoTemplate.count(query, User.class));
    }
}
