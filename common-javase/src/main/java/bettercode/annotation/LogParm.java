package bettercode.annotation;

import java.lang.annotation.*;

/**
 * 用于记录日志的操作参数
 * Create by wws on 2019/4/22
 */
    @Target({ElementType.PARAMETER, ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
        @Documented
public @interface LogParm {



        /** 要执行的操作类型比如：add操作 **/
            String operationAction() default "xxx";


          String  operationMOdel() default "请输入操作类型";

          String  operationFunction() default "操作说明";


}
