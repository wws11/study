package juc.demo.extenddtype;

/**
 * @Description  创建一个让动物停止的类，这里要实现回调接口
 * @Author DJZ-WWS
 * @Date 2019/4/4 9:41
 */
public class LetOneStop  implements Animal.Calltoback {


    Animal animal;

    public   LetOneStop(Animal animal){

        this.animal=animal;
    }

    @Override
    public void win() {

        //线程停止
        animal.stop();
    }
}
