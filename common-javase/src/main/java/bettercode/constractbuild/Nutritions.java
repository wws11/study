package bettercode.constractbuild;

/**
 * @Description   当构造器过多的时候使用java bean的方式代替原生构造器的方式，当然如果再多就考虑另一种方式了，使用Build模式
 *
 * 设计思想通过内部类的方式。给让内部类拥有外部类所有的属性，在通过外部类有构造器，构造器参数是内部类定义，将内部类的值赋给外部类的属性
 * @Author DJZ-WWS
 * @Date 2019/5/5 8:53
 */
public class Nutritions {

    private    final   int  servingSize;

    private   final   int  servings;

    private   final  int  calories;

    private   final  int  fat;

    private   final int  sodium;

    private   final    int  carbohydrate;



    public    static class  Builder{
        private     int  servingSize;

        private    int servings;

        private   int caloriies=0;
        private   int  fat=0;
        private   int  carbohydrate=0;
        private  int  sodium=0;

        public   Builder(int  servingSize,int  servings){
            this.servingSize=servingSize;
            this.servings=servings;
        }

        public   Builder  colories(int  var){
            caloriies=var;
            return   this;
        }

        public   Builder fat(int  var){
            fat=var;
            return  this;
        }
        public Builder carbohydrate(int  var){
            carbohydrate=var;
            return   this;
        }

        public  Builder sodium(int  var){
            sodium=var;
            return  this;
        }

        public   Nutritions  builder(){
            return   new Nutritions(this);
        }
    }
    private   Nutritions  (Builder builder){
        servingSize=builder.servingSize;
        servings=builder.servings;
        calories= builder.caloriies;
        fat=builder.fat;
        sodium=builder.sodium;
        carbohydrate=builder.carbohydrate;
    }

    @Override
    public String toString() {
        return "Nutritions{" +
                "servingSize=" + servingSize +
                ", servings=" + servings +
                ", calories=" + calories +
                ", fat=" + fat +
                ", sodium=" + sodium +
                ", carbohydrate=" + carbohydrate +
                '}';
    }
}
