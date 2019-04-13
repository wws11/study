package test.sort;


import java.util.Comparator;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/4/11 20:35
 */
public class Mycomparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        if (o1 instanceof Fruit && o2 instanceof Fruit) {
            Fruit f1 = (Fruit) o1;
            Fruit f2 = (Fruit) o2;
            if (f1.getPrice() > f2.getPrice()) {
                return -1;
            } else {
                return 1;
            }
        }
        return 0;
    }
}