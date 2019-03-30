package enumtest;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/2/28 15:51
 */
public enum Planet {

    /**
     *
     *
     */
    MERCURY(3.302e+23,2.34243),VENUS(2.23,6.543)
    ;

    private   final  double  mass;
    private final  double radius;
    private  final double surface;

private  static  final double G=6.67300E-11;

    public double getMass() {
        return mass;
    }

    public double getRadius() {
        return radius;
    }

    public double getSurface() {
        return surface;
    }

private    Planet(double mass,double radius){
   this.mass=mass;
   this.radius=radius;
   this.surface=G*mass/(radius*radius);
}


public   double  getSuffer(){
        return  mass*surface;
}

}
