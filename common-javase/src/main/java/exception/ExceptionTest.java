package exception;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/3/5 16:10
 */
public class ExceptionTest {

    /**
     * 使用了try catch 处理之后不影响后面程序你的执行
     * 如果直接抛出去的话是会终止程序运行的
     * @param args
     * @throws IllegalAccessException
     */
    public static void main(String[] args) throws IllegalAccessException {
        try {

        }catch (Exception e){

        for (int i = 0; i < 10; i++) {

            if(i>5){




            }
            System.out.println(i);
        }

            throw new  IllegalAccessException("参数异常");

        }

    }
}
