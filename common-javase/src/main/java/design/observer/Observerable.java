package design.observer;


/**
 * @Description  抽象被观察者接口
 * @Author DJZ-WWS
 * @Date 2019/4/8 14:26
 */
public interface Observerable {

     void registerObserver(Observer o);
     void removeObserver(Observer o);
     void notifyObserver();
}