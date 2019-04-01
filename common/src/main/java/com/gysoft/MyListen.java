package com.gysoft;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/3/30 14:56
 */


/**
 * 按监听对象划分  可以分为
 *  *
 *  *   ServletContext 对象的监听器
 *  *   HTTPSession对象监听器
 *  *   ServletRequest对象监听器
 *  *   按监听事件划分
 *  *      对象自身的创建和销毁的监听器
 *  *      对象中属性的创建和消除的监听器
 *  *      session中的某个对象的状态变化的监听器
 */

public class MyListen  implements HttpSessionListener {
        public   int  count =0;

    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        //监听session的创建
        count ++;
        httpSessionEvent.getSession().getServletContext().setAttribute("Count",count);
    }

    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
    //监听session的销毁
        count--;
        httpSessionEvent.getSession().getServletContext().setAttribute("Count",count);
    }
}

