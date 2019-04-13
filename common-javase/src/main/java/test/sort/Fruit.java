package test.sort;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/4/11 20:36
 */
public class Fruit {
    private  String name;
    private  double price;

    public Fruit() {

    }

    public Fruit(String name, double price) {
        super();
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return  name +":" + price;

    }
}