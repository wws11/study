package design.build;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/4/1 20:25
 */
public class MainApp {

    public static void main(String[] args) {


        Builder  builder=new ConcreteBuilder();

        Director   director=new  Director ();

        director.constructProduct((ConcreteBuilder) builder);
        Product product = builder.buildProduct();
        System.out.println(product.getBasic());
        System.out.println(product.getRoofed());
        System.out.println(product.getWall());

    }

}
