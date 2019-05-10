package com.gysoft.annotation;

import java.lang.annotation.*;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/5/9 11:40
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface WRequestMapping {

    String value() default "";
}