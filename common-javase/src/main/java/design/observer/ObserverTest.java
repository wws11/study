package design.observer;

/**
 * @escription  测试观察者模式    发布订阅   模拟微信聊天关注可以收到消息，取消关注不能收到消息
                    设计的思想   利用容器存储订阅的用户，利用用户message属性接受推送的消息
 * @Author DJZ-WWS
 * @Date 2019/4/8 14:34
 */
public class ObserverTest {

    public static void main(String[] args) {
        WechatServer server = new WechatServer();

        Observer userZhang = new User("ZhangSan");
        Observer userLi = new User("LiSi");
        Observer userWang = new User("WangWu");
       //订阅
        server.registerObserver(userZhang);
        server.registerObserver(userLi);
        server.registerObserver(userWang);
        server.setInfomation("PHP是世界上最好用的语言！");
        System.out.println("----------------------------------------------");
       //取消关注
        server.removeObserver(userZhang);
        server.setInfomation("JAVA是世界上最好用的语言！");
    }
}
