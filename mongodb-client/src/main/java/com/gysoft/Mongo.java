package com.gysoft;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/4/19 15:59
 */
public class Mongo {


    MongoClient mongoClient;
    MongoDatabase mongoDatabase;
    MongoCollection<Document> collection;

    @Before
    public void test1() {
        try {
            // 连接到 mongodb 服务
            mongoClient = new MongoClient("localhost", 27017);
            // 连接到数据库
            mongoDatabase = mongoClient.getDatabase("test01");
            //获取集合
             collection = mongoDatabase.getCollection("student");
            System.out.println("Connect to database successfully  ,database Name is" + mongoDatabase.getName());
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }


    //创建集合
    @Test
    public void test2() {
        try {
            mongoDatabase.createCollection("test2");
            System.out.println("集合创建成功");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }


    /**
     * 获取集合
     */

    @Test
    public void test3() {
        try {
            MongoCollection<Document> collection = mongoDatabase.getCollection("test01");
            System.out.println("集合 test 选择成功");
            System.out.println(collection.count());

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }

    }


    @Test
    public void test4() {
        Document document = new Document("name", "MongoDB").append("sex",1).append("age",100).append("address","weiwensisfdsfsffrree");
        List<Document> documents = new ArrayList<Document>();
        documents.add(document);
        collection.insertMany(documents);
        System.out.println("文档插入成功");
        //单个插入
        //collection.insertOne(Document);

    }

    @Test
    public void test5() {
        long count = collection.count();
       //1. 获取迭代器FindIterable<Document>
        System.out.println(count);
// * 2. 获取游标MongoCursor<Document>            * 3. 通过游标遍历检索出的文档集合

        FindIterable<Document> findIterable = collection.find();
        MongoCursor<Document> mongoCursor = findIterable.iterator();

        while(mongoCursor.hasNext()){
            System.out.println(mongoCursor.next());
        }
}

    @Test
    public void test6() {


    }
}
