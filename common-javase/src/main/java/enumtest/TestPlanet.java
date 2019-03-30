package enumtest;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/2/28 16:06
 */
public class TestPlanet
{


    public static void main(String[] args) {
        for(Planet  p:Planet.values()){
            System.out.println("p:  "+p+"  mass:  "+p.getMass()+"  radius:  "+p.getRadius());

        }

    }
}
