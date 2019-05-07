package com.gysoft.spring.beanpost;

        import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/5/7 14:02
 */
public class InstantionAwaredBeanPostTest {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext app=new ClassPathXmlApplicationContext("instantionAwareBeanPostProcessor.xml");

//        OneBean oneBean = app.getBean("$oneBean", OneBean.class);
        OneBean oneBean = app.getBean(OneBean.class);
        oneBean.doSomeThing();
        System.out.println(oneBean);  //由于打印对象的时候会默认走toString方法，所以也会走那个方法拦截器。
    }
}
