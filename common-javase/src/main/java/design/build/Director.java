package design.build;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/4/1 19:52
 */
public class Director {


    private  String  name;

    private    Director(){

    }

    public   Director(String name){
        this.name=name;
    }






    public  Product constructProduct(ConcreteBuilder concreteBuilder){
        concreteBuilder.buildBasic();
        concreteBuilder.buildWalls();
        concreteBuilder.roofed();
        return concreteBuilder.buildProduct();
    }


}
